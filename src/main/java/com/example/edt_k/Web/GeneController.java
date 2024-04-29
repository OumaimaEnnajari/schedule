package com.example.edt_k.Web;

import com.example.edt_k.DTO.GeneDTO;
import com.example.edt_k.entity.*;
import com.example.edt_k.repository.FiliereRepository;
import com.example.edt_k.service.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@Transactional
@RequestMapping("/edt")
public class GeneController {

    private PopulationServiceimp populationServiceimp;
    private GeneServiceImp geneService;
    private ExamenServiceImp examenServiceImp;
    private FiliereRepository filiereRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/test-genetic-algo")
    public ResponseEntity<List<Gene>> testGeneticAlgo() {
        if (examenServiceImp.countExams()!=0){
            examenServiceImp.DeleteAllExams();
            geneService.deleted();}
        Chromosome result = populationServiceimp.genetic_algo();
        List<Gene> genes = result.getGenes();
        for (Gene gene : genes) {
            gene.setCurrentDate(LocalDateTime.now());
            geneService.saveGene(gene);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /*@GetMapping("/classe")
    public ResponseEntity<List<Gene>> afficher_genes(){
        List<Gene> tmp = geneService.getGene();
        return new ResponseEntity<>(tmp,HttpStatus.OK);
    }
*/
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/essai")
    public ResponseEntity<List<GeneDTO>> affichage_all(){
        List<Gene> tmp = geneService.getGene();
        List<GeneDTO> geneDTOS=new ArrayList<>();
        for (Gene gene: tmp
        ) {
            GeneDTO geneDTO=GeneDTO.toDto(gene);

            geneDTOS.add(geneDTO);
        }
        return new ResponseEntity<>(geneDTOS,HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<GeneDTO> getGene(@PathVariable long id){
        Filiere filiere=filiereRepository.findById(id).orElse(null);
        Gene gene = filiere.getGene();
        Gene geneByid = geneService.getGeneWithDetails(gene.getId());

        return new ResponseEntity<>(GeneDTO.toDto(geneByid), HttpStatus.OK);
    }
}