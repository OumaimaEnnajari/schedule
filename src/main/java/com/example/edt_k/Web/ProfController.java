package com.example.edt_k.Web;
import com.example.edt_k.entity.AppUser;
import com.example.edt_k.entity.Prof;
import com.example.edt_k.service.AccountService;
import com.example.edt_k.service.ProfServiceImp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProfController {

    private ProfServiceImp profService;
    private AccountService accountService;
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/profs")
    public ResponseEntity<Object> saveProf(@RequestBody ProfRequest p) {
        if(p!=null)
        {
            Prof P=new Prof();
            P.setNom(p.getNom());
            P.setPPR(p.getPpr());
            AppUser user=new AppUser(P.getNom(),"1234");
            accountService.AddNewUser(user);
            AppUser u=accountService.LoadUserByUsername(P.getNom());
            P.setUser(u);

//        accountService.AddNewUser(user);
            accountService.AddRoleToUser("PROF",P.getNom());
            profService.saveProf(P);
            return ResponseEntity.status(200).body("Prof created successfully \n "+P.toString());
        }
        return ResponseEntity.status(401).body("nothing to add");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("profs/{id}")
    public ResponseEntity<Prof> getProf(@PathVariable long id) {
        return new ResponseEntity<>(profService.getById(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/profs/delete/{id}")
    public ResponseEntity<Object> deleteProf(@PathVariable Long id) {
        boolean deletionSuccessful = profService.deleteProfByID(id);

        if (deletionSuccessful) {
            return ResponseEntity.status(200).body("Deleted successfully");
        } else {
            return ResponseEntity.status(404).body(" error");
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/profs")
    public ResponseEntity<List<Prof>> getProfs() {
        return new ResponseEntity<>(profService.getProfs(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/profs/search/{nom}")
    public ResponseEntity<List<Prof>> getProfByName(@PathVariable String nom) {
        List<Prof> listProfs = profService.SearchByMc(nom);
        return new ResponseEntity<>(listProfs, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/profs/edit/{id}")
    public ResponseEntity<Object> editProf(@PathVariable Long id, @RequestBody ProfRequest form)
    {
        Prof P=profService.getProfById(id);
        if (P== null) {
            return ResponseEntity.status(404).body("Professor not found with ID: " + id);
        }
        else{
            Prof new_p=new Prof();
            new_p.setId(P.getId());
            new_p.setNom(form.getNom());
            new_p.setPPR(form.getPpr());
            new_p.setUser(P.getUser());

            return new ResponseEntity<>( profService.updateProf(id,new_p), HttpStatus.OK);

        }

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/check")
    public ResponseEntity<Object> getIDifProf(@RequestBody AppUser u) {
        AppUser user = accountService.LoadUserByUsernamePassword(u.getUserName(), u.getPassword());
        Reponse r = new Reponse();
        if(user==null) {
            r.setRep(-1L);
            // Si l'utilisateur ou le professeur n'est pas trouvé, renvoyer une réponse 404
            return new ResponseEntity<>(r, HttpStatus.OK);
        }
        Prof p = profService.LoadProfByUserId(user.getId()).orElse(null); // Utilisation de orElse pour obtenir le Prof ou null

            if (p != null) {
                r.setRep(p.getId());
                return new ResponseEntity<>(r, HttpStatus.OK);
            } else {
                r.setRep(0L);
                return new ResponseEntity<>(r, HttpStatus.OK);
            }


    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ProfRequest
{
    private String nom;
    private String ppr;

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class EditRequest
{
    private String ppr;
    private String nom;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Reponse {
    private Long rep;
}