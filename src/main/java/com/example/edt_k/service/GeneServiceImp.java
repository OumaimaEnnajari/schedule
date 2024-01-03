package com.example.edt_k.service;

import com.example.edt_k.entity.Examen;
import com.example.edt_k.entity.Module;
import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Gene;
import com.example.edt_k.entity.Semestre;
import com.example.edt_k.repository.GeneRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GeneServiceImp implements GeneService{
    private GeneRepository geneRepository;
    private ModuleServiceImp moduleServiceImp;
    private ExamenServiceImp examenServiceImp;
    private FiliereServiceImp filiereServiceImp;

    @Override
    public Gene generate_random_edt(Filiere filiere, Optional<Semestre> semestre) {
        Gene gene = new Gene();
        gene.setFiliere(filiere);
        List<Examen> examenList = new ArrayList<>();
        for (Module module : moduleServiceImp.getModulesByFiliere(filiere)) {
                Examen examen=examenServiceImp.random_Examen(gene, module);
                examenList.add(examen);
        }
        gene.setExams(examenList);
        return gene;
    }

    @Override
    @Transactional
    public void saveGene(Gene gene) {
        Gene g=geneRepository.save(gene);
        for (Examen examen:g.getExams()){
            examenServiceImp.saveExamen(examen);
        }
    }
}
