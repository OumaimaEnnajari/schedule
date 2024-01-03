package com.example.edt_k.service;

import com.example.edt_k.entity.Chromosome;
import com.example.edt_k.entity.Population;
import com.example.edt_k.entity.Semestre;

import java.util.Optional;

public interface PopulationService {
    Population generer_population(Optional<Semestre> semestre);
    Population crossoverPopulation(Population population, Optional<Semestre> semestre);
    int pop_per(int size,double pourcentage);
    public int random_int(int start, int end);
    public Population evolve(Population population, Optional<Semestre> semestre);
    public Chromosome genetic_algo(Optional<Semestre> semestre);
}
