package com.example.edt_k.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population {
    private final int size=50;
    private List<Chromosome> chromosomes=new ArrayList<>();


}
