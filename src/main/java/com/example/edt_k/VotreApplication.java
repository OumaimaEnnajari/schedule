package com.example.edt_k;

import com.example.edt_k.entity.*;
import com.example.edt_k.entity.Module;
import com.example.edt_k.repository.SalleRepository;
import com.example.edt_k.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.*;

@SpringBootApplication
public class VotreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(VotreApplication.class, args);
        SalleService salleService = context.getBean(SalleService.class);
        SemestreService semestreService=context.getBean(SemestreService.class);
        ProfService profService=context.getBean(ProfService.class);
        ModuleService moduleService=context.getBean(ModuleService.class);
        PopulationService populationService= context.getBean(PopulationService.class);
        FiliereService filiereService=context.getBean(FiliereService.class);
        ExamenService examenService=context.getBean(ExamenService.class);
        GeneService geneService=context.getBean(GeneService.class);
        ChromosomeService chromosomeService=context.getBean(ChromosomeService.class);

        Optional<Module> module=moduleService.getModuleById(8L);

        Filiere filiere=filiereService.getFiliereByModule(module);
       List<Module> modules=moduleService.getModulesByFiliere(filiere);


        Optional<Semestre> semestre=semestreService.getSemestreById(1L);
        Gene gene=new Gene();
       //gene=geneService.generate_random_edt(filiere,semestre);
       // System.out.println(gene);
        Chromosome c=populationService.genetic_algo(semestre);
        System.out.println(c);









        // Appelez votre service













    }
}
