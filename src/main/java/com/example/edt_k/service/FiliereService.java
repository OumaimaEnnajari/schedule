package com.example.edt_k.service;

import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Module;

import java.util.List;

public interface FiliereService {
    Filiere getFiliereByModule(Module course);
    public List<Filiere> getFiliere();

}
