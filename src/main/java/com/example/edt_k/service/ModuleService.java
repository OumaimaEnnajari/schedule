package com.example.edt_k.service;

import com.example.edt_k.entity.Module;
import com.example.edt_k.entity.Semestre;

import java.util.List;

public interface ModuleService  {
    //retourne le prof qui enseigne un module
   // Prof getProfByModule(Module module);
    List<Module> getModuleBySemestre(Semestre semestre);
}
