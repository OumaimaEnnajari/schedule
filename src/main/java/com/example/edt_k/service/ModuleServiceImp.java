package com.example.edt_k.service;

import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Module;
import com.example.edt_k.repository.ModuleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModuleServiceImp implements ModuleService{
    private ModuleRepository moduleRepository;


    @Override
    public Optional<Module> getModuleById(Long id) {
        return moduleRepository.findById(id);
    }


    @Override
    public List<Module> getModulesByFiliere(Filiere filiere) {
        return moduleRepository.findByFiliere(filiere);
    }

}
