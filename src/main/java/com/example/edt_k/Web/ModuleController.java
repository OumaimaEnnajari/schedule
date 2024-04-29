package com.example.edt_k.Web;
import com.example.edt_k.DTO.ModuleDTO;
import com.example.edt_k.Json_Object.ModuleObject;
import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Prof;
import com.example.edt_k.repository.FiliereRepository;
import com.example.edt_k.repository.ProfRepository;
import com.example.edt_k.service.ExamenServiceImp;
import com.example.edt_k.service.GeneServiceImp;
import com.example.edt_k.service.ModuleServiceClass;
import com.example.edt_k.service.ModuleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

import com.example.edt_k.entity.Module;

@RestController
@RequestMapping("/modules")
public class ModuleController {
    @Autowired
    private ModuleServiceImp moduleService;
    @Autowired
    private ModuleServiceClass moduleServiceClass;
    @Autowired
    private ExamenServiceImp examenServiceImp;
    @Autowired
    private GeneServiceImp geneServiceImp;
    @Autowired
    private ProfRepository profRepository;
    @Autowired
    private FiliereRepository filiereRepository;

    @CrossOrigin(origins = "http://localhost:3000")
   @PostMapping
    public ResponseEntity<Object> saveModule(@RequestBody ModuleObject module) {
        Prof prof;
        if(module.getPPR()==null) {
            List<Prof> profs = profRepository.chercherprof(module.getProfNom());
            if(profs.size()!=0)
                prof= profs.get(0);
            else
                return ResponseEntity.status(200).body("Prof n'existe pas ");
        }
        else
            prof= profRepository.getProfByPPR(module.getPPR()).orElse(null);
       Filiere filiere= filiereRepository.chercherFiliereParNom(module.getFiliereNom());
        examenServiceImp.DeleteAllExams();
        geneServiceImp.deleted();
        Module m= new Module();
        m.setNom(module.getNom());
        m.setProf(prof);
        m.setFiliere(filiere);
        m.setPrise(module.isPrise());
       moduleServiceClass.saveModule(m);
       return ResponseEntity.status(200).body("module created successfully");

    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModule(@PathVariable Long id) {
        return new ResponseEntity<>(moduleService.getById(id), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("all/{id}")
    public ResponseEntity<List<ModuleDTO>> getByMoldulee(@PathVariable Long id) {
        List<ModuleDTO> moduleDTOs = moduleServiceClass.getById(id);
        return new ResponseEntity<>(moduleDTOs, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<List<ModuleDTO>> getAllModules() {
        List<ModuleDTO> moduleDTOs = moduleServiceClass.getAllModulesWithDetails();
        return new ResponseEntity<>(moduleDTOs, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/update/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody ModuleObject newModule) {
        examenServiceImp.DeleteAllExams();
        geneServiceImp.deleted();
        Module updatedModule = moduleService.updateModule1(id,newModule);
        return new ResponseEntity<>(updatedModule, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteModule(@PathVariable Long id) {
        examenServiceImp.DeleteAllExams();
        geneServiceImp.deleted();
        moduleService.deleteModule(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteModuleByNom(@PathVariable String id) {
        examenServiceImp.DeleteAllExams();
        geneServiceImp.deleted();
        moduleService.deleteModuleByNom(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
