package com.example.edt_k.Web;

import com.example.edt_k.DTO.Exam_Time_DTO;
import com.example.edt_k.DTO_2.Module_DTO_2;
import com.example.edt_k.DTO_2.Prof_Dto_2;
import com.example.edt_k.entity.Examen;
import com.example.edt_k.entity.Prof;
import com.example.edt_k.entity.Salle;
import com.example.edt_k.repository.ExamenRepository;
import com.example.edt_k.service.ProfServiceImp;
import com.example.edt_k.service.SalleServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping("/edtp")
public class Edt_Prof_Controller {
    private ProfServiceImp profServiceImp;
    private ExamenRepository examenRepository;
    private SalleServiceImp salleServiceImp;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/prof")
    public ResponseEntity<List<Map<String, Object>>> edt_prof() {
        List<Map<String, Object>> profSalleList = new ArrayList<>();

        for (Examen examen : examenRepository.findAll()) {
            Set<Prof> profs = profServiceImp.getProfsByExamenId(examen.getId());
            Set<Salle> availableSalles = salleServiceImp.getSallesByExamenId(examen.getId());

            for (Prof prof : profs) {
                Map<String, Object> responseMap = new HashMap<>();

                if (!availableSalles.isEmpty()) {
                    Salle salle = availableSalles.iterator().next();

                    // Informations sur le professeur
                    responseMap.put("profId", prof.getId());
                    responseMap.put("profNom", prof.getNom());

                    // Informations sur l'examen et le module en utilisant la DTO_2
                    Module_DTO_2 moduleDto = Module_DTO_2.toDTO_2(examen.getModule());
                    responseMap.put("module", moduleDto);

                    // Informations sur l'examen time en utilisant la DTO
                    Exam_Time_DTO examTimeDto = Exam_Time_DTO.toDto(examen.getExamTime());
                    responseMap.put("examTime", examTimeDto);

                    // Informations sur la salle
                    responseMap.put("salleId", salle.getId());
                    responseMap.put("salleName", salle.getName());

                    profSalleList.add(responseMap);
                }
            }
        }

        return new ResponseEntity<>(profSalleList, HttpStatus.OK);
    }

        @GetMapping("/pro/{id}")
        public ResponseEntity<Prof_Dto_2> edt_pro ( @PathVariable long id){
            Prof prof = profServiceImp.getProfById(id);
            Prof_Dto_2 profDto = Prof_Dto_2.toDto_2(prof);
            return new ResponseEntity<>(profDto, HttpStatus.OK);
        }
    }

