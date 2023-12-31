package com.example.edt_k.service;

import com.example.edt_k.entity.Population;

public interface PopulationService {
    Population generer_population(int size);
    Population crossoverPopulation(Population population);
    int pop_per(int size,double pourcentage);
}
