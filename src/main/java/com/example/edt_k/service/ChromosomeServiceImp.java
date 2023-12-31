package com.example.edt_k.service;

import com.example.edt_k.entity.Chromosome;
import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Gene;
import com.example.edt_k.entity.Semestre;
import com.example.edt_k.repository.FiliereRepository;
import com.example.edt_k.repository.GeneRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class ChromosomeServiceImp implements ChromosomeService {
    @Autowired
    private GeneServiceImp geneServiceImp;
    private FiliereServiceImp filiereServiceImp;
    private SalleServiceImp salleServiceImp;
    private ProfServiceImp profServiceImp;
    private int nbrConflits=0;
    private double fitness=0;
    List<Gene> genes;

    @Override
    public Chromosome generate_schedules(Semestre semestre) {
        Chromosome chromosome=new Chromosome();
        genes=new ArrayList<>();
        for (Filiere filiere:filiereServiceImp.getFiliere()){
            genes.add(geneServiceImp.generate_random_edt(filiere,semestre));
        }
        fitness = calcul_fitness();

        return chromosome;
    }

    @Override
    public Chromosome crossoverChromosome(Chromosome chromosome1, Chromosome chromosome2, Semestre semestre) {
        Chromosome chromosome = generate_schedules(semestre);
        IntStream.range(0, chromosome.getGenes().size()).forEach(x->{
            if (Math.random() <0.45){
                chromosome.getGenes().set(x, chromosome1.getGenes().get(x));
            } else if (Math.random()<0.9) {
                chromosome.getGenes().set(x, chromosome2.getGenes().get(x));
            }else {
                chromosome.getGenes().set(x,geneServiceImp.generate_random_edt(chromosome1.getGenes().get(x).getFiliere(),semestre));
            }
        });
        return chromosome;
    }

    @Override
    public double calcul_fitness() {
        nbrConflits+=conflit();
        return nbrConflits;
    }

    @Override
    public int conflit() {
        int nbr_conflits=0;
        for(int i=0;i<genes.size()-1;i++){
            for (int m=0;m<genes.get(i).getExams().size();m++)
            {
                for (int j=i+1;j<genes.size();j++){
                    for (int n=0;n<genes.get(j).getExams().size();n++){
                        if (genes.get(i).getExams().get(m).getExamTime().getId()==genes.get(j).getExams().get(n).getExamTime().getId()){
                            if (salleServiceImp.haveCommonSalle(genes.get(i).getExams().get(m).getSalles(),genes.get(j).getExams().get(n).getSalles()))
                                nbr_conflits++;
                            if (profServiceImp.haveCommonSurveillant(genes.get(i).getExams().get(m).getProfs(),genes.get(j).getExams().get(n).getProfs()))
                                nbr_conflits++;
                        }
                    }
                }
            }
        }
        return nbr_conflits;
    }
}
