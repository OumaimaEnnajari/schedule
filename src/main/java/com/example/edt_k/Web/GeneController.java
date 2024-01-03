package com.example.edt_k.Web;

import com.example.edt_k.entity.Chromosome;
import com.example.edt_k.entity.Semestre;
import com.example.edt_k.service.PopulationServiceimp;
import com.example.edt_k.service.SemestreServiceImp;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RestController
@AllArgsConstructor
@RequestMapping("/edt")
public class GeneController {
    private SemestreServiceImp semestreServiceImp;
    private PopulationServiceimp populationServiceimp;



    // Endpoint pour tester genetic_algo
    @GetMapping("/test-genetic-algo/{idSemestre}")
    public ResponseEntity<Chromosome> testGeneticAlgo(@PathVariable long idSemestre) {
        Optional<Semestre> semestre = semestreServiceImp.getSemestreById(idSemestre);

        if (semestre.isPresent()) {
            // Appel de la méthode genetic_algo pour tester
            Chromosome result = populationServiceimp.genetic_algo(semestre);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}