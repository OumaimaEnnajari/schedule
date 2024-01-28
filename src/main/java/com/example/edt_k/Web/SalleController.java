package com.example.edt_k.Web;

import com.example.edt_k.entity.Salle;
import com.example.edt_k.service.SalleServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/salle")
public class SalleController {
    private SalleServiceImp salleServiceImp;

    @PostMapping
    public ResponseEntity<Salle> saveSalle(@RequestBody Salle salle){
        return new ResponseEntity<>(salleServiceImp.saveSalle(salle), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salle> getSalle(@PathVariable long id){
        return new ResponseEntity<>(salleServiceImp.getSalle(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSalle(@PathVariable long id){
        salleServiceImp.deleteSalle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Salle>> getSalles() {
        return new ResponseEntity<>(salleServiceImp.getSalles(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salle> updateSalle(@PathVariable long id, @RequestBody Salle newSalle) {
        Salle updatedSalle = salleServiceImp.updateSalle(id, newSalle);
        return new ResponseEntity<>(updatedSalle, HttpStatus.OK);}

}
