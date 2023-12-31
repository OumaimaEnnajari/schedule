package com.example.edt_k.service;

import com.example.edt_k.entity.Chromosome;
import com.example.edt_k.entity.Population;
import com.example.edt_k.entity.Semestre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.stream.IntStream;

@Service
public class PopulationServiceimp implements PopulationService{
    @Autowired
    private ChromosomeServiceImp chromosomeServiceImp;
    @Override
    public Population generer_population(Semestre semestre,int size) {
        Population p=new Population();
        for (int i = 0; i < size; i++) {
            p.getChromosomes().add(chromosomeServiceImp.generate_schedules(semestre));
        }
        Collections.sort(p.getChromosomes());
        return p;
    }

    @Override
    public Population crossoverPopulation(Population population, Semestre semestre) {
        int size  = population.getSize();
        Population new_generation = generer_population(semestre,size);
        //add the 10% of the old best population to the new generation
        IntStream.range(0,pop_per(size,0.1)).forEach(x->{
            new_generation.getChromosomes().set(x,population.getChromosomes().get(x));
        });
        //mariage of the 50% of the best old population
        IntStream.range(pop_per(size,0.1),size).forEach(x->{
            if (Math.random() < 0.9){
                int r = random_int(0,pop_per(size,0.5));
                int r2 = random_int(0,pop_per(size,0.5));
                Chromosome chromosome = chromosomeServiceImp.crossoverChromosome(population.getChromosomes().get(r),population.getChromosomes().get(r2),semestre);
                new_generation.getChromosomes().set(x,chromosome);
            }else {
                new_generation.getChromosomes().set(x,chromosomeServiceImp.generate_schedules(semestre));
            }
        });
        return new_generation;
    }

    @Override
    public int pop_per(int size, double pourcentage) {
        return (int)(pourcentage*size);
    }

    @Override
    public int random_int(int start, int end) {
        return  (int)((end-start)*Math.random()) + start;
    }
}
