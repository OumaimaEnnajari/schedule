package com.example.edt_k.service;

import com.example.edt_k.entity.Prof;
import com.example.edt_k.entity.Module;

public interface ModuleService  {
    //retourne le prof qui enseigne un module
    Prof getProfByModule(Module module);
}
