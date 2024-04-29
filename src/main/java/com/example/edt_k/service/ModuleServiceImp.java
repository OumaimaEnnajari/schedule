package com.example.edt_k.service;

import com.example.edt_k.Json_Object.ModuleObject;
import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Module;
import com.example.edt_k.entity.Prof;
import com.example.edt_k.repository.FiliereRepository;
import com.example.edt_k.repository.ModuleRepository;
import com.example.edt_k.repository.ProfRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.edt_k.exception.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModuleServiceImp implements ModuleService{
    private ModuleRepository moduleRepository;
    private FiliereRepository filiereRepository;
    private ProfRepository profRepository;
    @Override
    public Optional<Module> getModuleById(Long id) {
        return moduleRepository.findById(id);
    }


    @Override
    public List<Module> getModulesByFiliere(Filiere filiere) {
        return moduleRepository.findByFiliere(filiere);
    }

    @Override
    public Module getById(Long id) {
        return moduleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    @Override
    public Module saveModule(Module module) {
        return moduleRepository.save(module);
    }
        @Override
    public void deleteModuleByNom(String nom) {
            moduleRepository.deleteByNom(nom);
    }

    @Override
    public Module updateModule(Long id, Module newModule) {
        Module existingModule = moduleRepository.findById(id).orElse(null);
        if (existingModule != null) {
            existingModule.setNom(newModule.getNom());
        }
            return moduleRepository.save(existingModule);
    }
@Override
    public Module updateModule1(Long id, ModuleObject newModule) {
        Module existingModule = moduleRepository.findById(id).orElse(null);
        Filiere existinFiliere= filiereRepository.chercherFiliereParNom(newModule.getFiliereNom());
        if (existingModule != null) {
            Prof existingProf;
            existingModule.setNom(newModule.getNom());
            existingModule.setPrise(newModule.isPrise());
            existingModule.setFiliere(existinFiliere);

            if(newModule.getPPR()==null) {
                existingProf =  profRepository.findByNom(newModule.getProfNom()).orElse(null);
                existingModule.setProf(existingProf);
            }
            else {
                existingProf=profRepository.getProfByPPR(newModule.getPPR()).orElse(null);
                existingModule.setProf(existingProf);
            }

            return moduleRepository.save(existingModule);
        }

        return null;
    }

    @Override
    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }

}
