package com.example.edt_k.service;

import com.example.edt_k.entity.Chromosome;
import com.example.edt_k.entity.Population;
import com.example.edt_k.entity.Semestre;
import org.springframework.stereotype.Service;

@Service
public interface ChromosomeService {
    public Chromosome generate_schedules(Semestre semestre);
    public Chromosome crossoverChromosome(Chromosome chromosome1, Chromosome chromosome2, Semestre semestre);
    public double calcul_fitness(Chromosome chromosome);
    public int conflit(Chromosome chromosome);
    public Chromosome genetic_algo(Population population,Semestre semestre);


}
