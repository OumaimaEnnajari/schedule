package com.example.edt_k.service;

import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Module;
import com.example.edt_k.entity.Semestre;

import java.util.List;
import java.util.Optional;

public interface ModuleService  {
    //retourne le prof qui enseigne un module
   // Prof getProfByModule(Module module);
    List<Module> getModuleBySemestre(Optional<Semestre> semestre);
    Optional<Module> getModuleById(Long id);
    public List<Module> getModulesByFiliere(Filiere filiere);
}
