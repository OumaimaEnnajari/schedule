package com.example.edt_k.service;

import com.example.edt_k.entity.Population;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

@Service
public class PopulationServiceimp implements PopulationService{
    @Autowired
    private ChromosomeServiceImp chromosomeServiceImp;
    private CommonServices commonServices;
    @Override
    public Population generer_population(int size) {
        Population p=new Population();
        for (int i = 0; i < size; i++) {
            p.getChromosomes().add(chromosomeServiceImp.generate_schedules());
        }
        Collections.sort(p.getChromosomes());
        return p;
    }

    @Override
    public Population crossoverPopulation(Population population) {
        int size  = population.getSize();
        Population new_generation = generer_population(size);
        //add the 10% of the old best population to the new generation
        IntStream.range(0,pop_per(size,0.1)).forEach(x->{
            new_generation.getChromosomes().set(x,population.getChromosomes().get(x));
        });
        return new_generation;
    }

    @Override
    public int pop_per(int size, double pourcentage) {
        return (int)(pourcentage*size);
    }
}
