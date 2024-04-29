package com.example.edt_k.service;

import com.example.edt_k.Json_Object.ModuleObject;
import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Module;

import java.util.List;
import java.util.Optional;

public interface ModuleService  {
    //retourne le prof qui enseigne un module
    // Prof getProfByModule(Module module);

    Optional<Module> getModuleById(Long id);
    public List<Module> getModulesByFiliere(Filiere filiere);
    Module getById(Long id);
    List<Module> getAllModules();
    Module saveModule(Module module);
    Module updateModule1(Long id, ModuleObject newModule);
    Module updateModule(Long id, Module newModule);
    void deleteModule(Long id);

    void deleteModuleByNom(String nom);

}
