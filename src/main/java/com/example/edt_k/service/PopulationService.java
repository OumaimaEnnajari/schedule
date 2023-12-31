package com.example.edt_k.service;

import com.example.edt_k.entity.Population;
import com.example.edt_k.entity.Semestre;

public interface PopulationService {
    Population generer_population(Semestre semestre);
    Population crossoverPopulation(Population population, Semestre semestre);
    int pop_per(int size,double pourcentage);
    public int random_int(int start, int end);
    public Population evolve(Population population,Semestre semestre);
}
