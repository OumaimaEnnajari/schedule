package com.example.edt_k.Web;

import com.example.edt_k.entity.Prof;
import com.example.edt_k.service.ProfServiceImp;
import com.example.edt_k.service.ProfServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/prof")
public class ProfController {

    private ProfServiceImp profService;

    @PostMapping
    public ResponseEntity<Prof> saveProf(@RequestBody Prof prof) {
        return new ResponseEntity<>(profService.saveProf(prof), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prof> getProf(@PathVariable long id) {
        return new ResponseEntity<>(profService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProf(@PathVariable long id) {
        profService.deleteProf(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Prof>> getProfs() {
        return new ResponseEntity<>(profService.getProfs(), HttpStatus.OK);
    }


}
