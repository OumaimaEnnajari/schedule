package com.example.edt_k.Web;

import com.example.edt_k.DTO.Duration_DTO;
import com.example.edt_k.entity.Duration;
import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Prof;
import com.example.edt_k.entity.Salle;
import com.example.edt_k.repository.ProfRepository;
import com.example.edt_k.service.DurationServiceImp;
import com.example.edt_k.service.FiliereServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/edt/filieres")
public class FilireController {
    @Autowired
    private FiliereServiceImp filiereServiceImp;
    private DurationServiceImp durationServiceImp;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/filieres")
    public ResponseEntity<List<Filiere>> getFilieres() {
        return new ResponseEntity<>(filiereServiceImp.getAllFilieres(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<Filiere> getFiliereById(@PathVariable Long id) {
        Optional<Filiere> filiere = filiereServiceImp.getFiliereById(id);
        return filiere.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Filiere> createFiliere(@RequestBody Filiere newFiliere) {
        Filiere createdFiliere = filiereServiceImp.saveFiliere(newFiliere);
        return new ResponseEntity<>(createdFiliere, HttpStatus.CREATED);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiliere(@PathVariable Long id) {
        filiereServiceImp.deleteFiliere(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/delete/{nom}")
    public ResponseEntity<HttpStatus> deleteFiliereByNom(@PathVariable String nom) {
        filiereServiceImp.deleteFiliereByNom(nom);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}")
    public ResponseEntity<Filiere> updateFiliere(@PathVariable long id, @RequestBody Filiere newFiliere) {
        filiereServiceImp.updateFiliere(id, newFiliere);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/durations")
    public ResponseEntity<List<Duration_DTO>>  getDurations(){
        List<Duration_DTO> durationDtos= new ArrayList<>();
        List<Duration> durations = durationServiceImp.getDurations();
        for (Duration duration:durations
        ) {
            durationDtos.add(Duration_DTO.toDto(duration));
        }
        return new ResponseEntity<>(durationDtos,HttpStatus.OK);
    }
}
