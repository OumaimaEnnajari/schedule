package com.example.edt_k.Web;

import com.example.edt_k.entity.Chromosome;
import com.example.edt_k.service.PopulationServiceimp;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RestController
@AllArgsConstructor
@RequestMapping("/edt")
public class GeneController {

    private PopulationServiceimp populationServiceimp;

    // Endpoint pour tester genetic_algo
    @GetMapping("/test-genetic-algo")
    public ResponseEntity<Chromosome> testGeneticAlgo() {
            Chromosome result = populationServiceimp.genetic_algo();
            return new ResponseEntity<>(result, HttpStatus.OK);

    }

    //@PostMapping()



}