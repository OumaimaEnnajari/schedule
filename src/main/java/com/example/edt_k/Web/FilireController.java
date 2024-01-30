package com.example.edt_k.Web;

import com.example.edt_k.entity.Filiere;
import com.example.edt_k.service.FiliereServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/edt/filieres")
public class FilireController {
    @Autowired
    private FiliereServiceImp filiereServiceImp;

    @GetMapping("/filieres")
    public ResponseEntity<List<Filiere>> getFilieres() {
        return new ResponseEntity<>(filiereServiceImp.getAllFilieres(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filiere> getFiliereById(@PathVariable Long id) {
        Optional<Filiere> filiere = filiereServiceImp.getFiliereById(id);
        return filiere.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Filiere> createFiliere(@RequestBody Filiere newFiliere) {
        Filiere createdFiliere = filiereServiceImp.saveFiliere(newFiliere);
        return new ResponseEntity<>(createdFiliere, HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiliere(@PathVariable Long id) {
        filiereServiceImp.deleteFiliere(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
