package com.example.edt_k.service;

import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Gene;
import com.example.edt_k.entity.Module;
import com.example.edt_k.repository.GeneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GeneServiceImp implements GeneService{
    private GeneRepository geneRepository;
    private ModuleServiceImp moduleServiceImp;
    private ExamenerviceImp examenerviceImp;

    @Override
    public Gene generate_random_edt(Filiere filiere) {
        Gene gene = new Gene();
        gene.setFiliere(filiere);
        for (Module module: filiere.getModules()){
          gene.(examenerviceImp.random_Examen(gene,module));
        }
    }
}
