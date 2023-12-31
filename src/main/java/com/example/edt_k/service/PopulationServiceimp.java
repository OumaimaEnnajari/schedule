package com.example.edt_k.service;

import com.example.edt_k.entity.Population;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
@Service
public class PopulationServiceimp implements PopulationService{
    @Autowired
    private ChromosomeServiceImp chromosomeServiceImp;
    @Override
    public Population generer_population(int size) {
        Population p=new Population();
        p.chromosomes=new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            p.chromosomes.add(chromosomeServiceImp.generate_schedules());
        }
        Collections.sort(p.chromosomes);
        return p;
    }
}
