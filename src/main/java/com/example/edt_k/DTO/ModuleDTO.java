package com.example.edt_k.DTO;

import lombok.Data;

@Data
public class ModuleDTO {
    private Long id;
    private String nom;
    private String profNom;
    private Long profId;
    private String filiereNom;
    private boolean prise;
    // Constructeur, getters et setters
}

