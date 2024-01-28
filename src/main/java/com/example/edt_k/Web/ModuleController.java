package com.example.edt_k.Web;
import com.example.edt_k.service.ModuleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.edt_k.entity.Module;

@RestController
@RequestMapping("/modules")
public class ModuleController {

    @Autowired
    private ModuleServiceImp moduleService;

    @PostMapping
    public ResponseEntity<Module> saveModule(@RequestBody Module module) {
        return new ResponseEntity<>(moduleService.saveModule(module), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModule(@PathVariable Long id) {
        return new ResponseEntity<>(moduleService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Module>> getAllModules() {
        return new ResponseEntity<>(moduleService.getAllModules(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody Module newModule) {
        Module updatedModule = moduleService.updateModule(id,newModule);
        return new ResponseEntity<>(updatedModule, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
