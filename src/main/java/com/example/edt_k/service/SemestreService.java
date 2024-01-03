package com.example.edt_k.service;

import com.example.edt_k.entity.Semestre;

import java.util.Optional;

public interface SemestreService {
   Optional<Semestre> getSemestreById(Long id);
}
