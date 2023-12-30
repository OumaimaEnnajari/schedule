package com.example.edt_k.service;

import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Gene;

public interface GeneService {
    Gene generate_random_edt(Filiere filiere);

}
