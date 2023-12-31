package com.example.edt_k.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chromosome implements Comparable<Chromosome>{
    private int nbrConflits=0;
    private double fitness=0;
    List<Gene> genes;

    @Override
    public int compareTo(Chromosome o) {
        return Double.compare(o.fitness,this.fitness);
    }
}
