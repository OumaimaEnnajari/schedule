package com.example.edt_k.service;

import com.example.edt_k.entity.Module;
import com.example.edt_k.entity.Semestre;
import com.example.edt_k.repository.ModuleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModuleServiceImp implements ModuleService{
    private ModuleRepository moduleRepository;

   /* @Override
    public Prof getProfByModule(Module module) {
        return moduleRepository.findProfByModule(module).get();
    }*/

    @Override
    public List<Module> getModuleBySemestre(Semestre semestre) {
        return moduleRepository.findBySemestre(semestre);
    }
}
