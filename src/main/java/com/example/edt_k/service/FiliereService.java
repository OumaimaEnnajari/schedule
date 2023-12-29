package com.example.edt_k.service;

import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Module;
public interface FiliereService {
    Filiere getFiliereByModule(Module course);
}
