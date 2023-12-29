package com.example.edt_k.service;

import com.example.edt_k.entity.Module;
import com.example.edt_k.repository.GeneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GeneServiceImp implements GeneService{
    private GeneRepository geneRepository;
    private ModuleServiceImp moduleServiceImp;
    private ExamenerviceImp examenerviceImp;

    //l'argument represente les modules d'une filiere donnée
    @Override
    public void generate_random_edt(List<Module> modules) {
        for (Module module:modules
             ) {
            examenerviceImp.saveExamen(examenerviceImp.random_Examen(module));
        }
    }
}
