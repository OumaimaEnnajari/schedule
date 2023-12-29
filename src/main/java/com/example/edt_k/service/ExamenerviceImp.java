package com.example.edt_k.service;

import com.example.edt_k.entity.Exam_time;
import com.example.edt_k.entity.Examen;
import com.example.edt_k.entity.Module;
import com.example.edt_k.entity.Salle;
import com.example.edt_k.exception.EntityNotFoundException;
import com.example.edt_k.repository.ExamenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ExamenerviceImp implements ExamenService {
    private ExamenRepository examenRepository;
    private SalleServiceImp salleServiceImp;
    private FiliereServiceImp filiereServiceImp;
    private ProfServiceImp profServiceImp;
    private  Exam_timeServiceImp examTimeServiceImp;


    @Override
    public List<Examen> getExams() {
        return (List<Examen>) examenRepository.findAll();
    }

    @Override
    public List<Examen> getExamsByExamTime(Exam_time examTime) {
        List<Examen> examen =  examenRepository.findByExamTime(examTime);
         return unwrapExams(examen,examTime); // si il ya deja un examen dans ce meeting time => not empty => used
    }

    @Override
    public boolean isSameExamTime(Exam_time examTime) {
        //si true => il y a des examens programmes pour le meme horaire
        //on ne peut pas faire isEmpty
        return (getExamsByExamTime(examTime).size()>1);
    }

    static List<Examen> unwrapExams(List<Examen> entities, Exam_time examTime) {
        if (entities.isEmpty()) { //si pas d'examen ds le meeting time => excep levé
            throw new EntityNotFoundException(examTime, Examen.class);
        }else {
            return entities;
        }
    }
//!!!!!!!!!!!!!!!
    //retourne un examen en se basant sur le module
   /* @Override
    public Examen random_Examen(Module module) {
        //selon le module on va affecter les salles : avec prise sans prise
        //a partir du module je peux savoir la filiere
        Set<Salle> salles = salleServiceImp.random_list_salle(filiereServiceImp.getFiliereByModule(module),module.isPrise());
    }*/

    @Override
    public Examen random_Examen(Module course) {
       Set<Salle> salles = salleServiceImp.random_list_salle(filiereServiceImp.getFiliereByModule(course).getEffectif(), course.isPrise());
       Examen examen = new Examen();
       examen.setProfs(profServiceImp.random_surveillant_list(salles, course));
       examen.setCourse(course);
       examen.setSalles(salles);
        examen.setExamTime(examTimeServiceImp.random_Exam_Time());
        return examen;
    }

    @Override
    public Examen saveExamen(Examen examen) {
        return examenRepository.save(examen);
    }
}
