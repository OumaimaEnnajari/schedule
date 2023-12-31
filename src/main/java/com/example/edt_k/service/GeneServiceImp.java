package com.example.edt_k.service;

import com.example.edt_k.entity.Examen;
import com.example.edt_k.entity.Module;
import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Gene;
import com.example.edt_k.entity.Semestre;
import com.example.edt_k.repository.GeneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GeneServiceImp implements GeneService{
    private GeneRepository geneRepository;
    private ModuleServiceImp moduleServiceImp;
    private ExamenServiceImp examenServiceImp;

    @Override
    public Gene generate_random_edt(Filiere filiere, Semestre semestre) {
        Gene gene = new Gene();
        gene.setFiliere(filiere);

        //obtenir les modules d'un semestre
        List<Module> modulesSemestre = moduleServiceImp.getModuleBySemestre(semestre);

        List<Examen> examenList = new ArrayList<>();
        for (Module module : modulesSemestre) {
            //vérifier si le module appartient à la filiere spécifié
            if (module.getFiliere().equals(filiere)) {
                examenList.add(examenServiceImp.random_Examen(gene, module));
            }
        }
        gene.setExams(examenList);
        return gene;
    }
}
