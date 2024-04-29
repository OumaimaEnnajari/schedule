package com.example.edt_k.service;
import com.example.edt_k.Json_Object.ModuleObject;
import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Module;
import com.example.edt_k.repository.FiliereRepository;
import com.example.edt_k.repository.ModuleRepository;
import com.example.edt_k.DTO.ModuleDTO;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceClass {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private FiliereRepository filiereRepository;

    public List<ModuleDTO> getAllModulesWithDetails() {
        List<Module> modules = moduleRepository.findAllWithDetails();
        List<ModuleDTO> moduleDTOs = new ArrayList<>();

        for (Module module : modules) {
            ModuleDTO moduleDTO = new ModuleDTO();
            moduleDTO.setId(module.getId());
            moduleDTO.setNom(module.getNom());
            moduleDTO.setProfId(module.getProf().getId());
            moduleDTO.setProfNom(module.getProf().getNom());
            moduleDTO.setPrise(module.isPrise());
            moduleDTO.setFiliereNom(module.getFiliere().getNom_filiere());
            moduleDTOs.add(moduleDTO);
        }

        return moduleDTOs;
    }

    public List<ModuleDTO> getById(Long id) {
        Optional<Filiere> optionalFiliere = filiereRepository.findById(id);


        if (optionalFiliere.isPresent()) {
            Filiere filiere = optionalFiliere.get();


            List<Module> modules = moduleRepository.findByFiliere(filiere);
            List<ModuleDTO> moduleDTOs = new ArrayList<>();

            for (Module module : modules) {
                ModuleDTO moduleDTO = new ModuleDTO();
                moduleDTO.setId(module.getId());
                moduleDTO.setNom(module.getNom());
                moduleDTO.setProfId(module.getProf().getId());
                moduleDTO.setProfNom(module.getProf().getNom());
                moduleDTO.setPrise(module.isPrise());
                moduleDTO.setFiliereNom(module.getFiliere().getNom_filiere());
                moduleDTOs.add(moduleDTO);
            }

            return moduleDTOs;
        }

            return null;
    }

    public Module saveModule(Module module) {
        return moduleRepository.save(module);
    }
}
