package com.example.edt_k.service;

import com.example.edt_k.entity.Chromosome;
import org.springframework.stereotype.Service;

@Service
public interface ChromosomeService {
    public Chromosome generate_schedules();
    public Chromosome crossoverChromosome(Chromosome chromosome1, Chromosome chromosome2);
    public double calcul_fitness();
    public int conflit();


}
