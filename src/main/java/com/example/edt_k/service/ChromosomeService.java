package com.example.edt_k.service;

import com.example.edt_k.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ChromosomeService {
    public Chromosome generate_schedules(Optional<Semestre> semestre);
    public Chromosome generate_schedules(Optional<Semestre> semestre, List<Filiere> filieres);
    public Chromosome crossoverChromosome(Chromosome chromosome1, Chromosome chromosome2, Optional<Semestre> semestre);
    public double calcul_fitness(Chromosome chromosome);
    public int conflit(Chromosome chromosome);

    public Chromosome genetic_algo(Semestre semestre,List<Filiere> filieres);


}
