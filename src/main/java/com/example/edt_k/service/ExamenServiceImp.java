package com.example.edt_k.service;

import com.example.edt_k.entity.Module;
import com.example.edt_k.entity.*;
import com.example.edt_k.exception.EntityNotFoundException;
import com.example.edt_k.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ExamenServiceImp implements ExamenService {
    @Autowired
    private ExamenRepository examenRepository;
    @Autowired
    private SalleServiceImp salleServiceImp;
    @Autowired
    private ProfServiceImp profServiceImp;
    @Lazy
    @Autowired
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

   /* @Override
    public boolean isSameExamTime(Exam_time examTime) {
        //si true => il y a des examens programmes pour le meme horaire
        //on ne peut pas faire isEmpty
        return (getExamsByExamTime(examTime).size()>1);
    }*/

    @Override
    public boolean isSameExamTime(Exam_time examTime, Gene gene) {
        for (Examen examen : gene.getExams()
             ) {
            if(examen.getExamTime()==examTime)
                return true;
        }
        return false;
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

    /*@Override
    public Examen random_Examen(Module course) {
       Set<Salle> salles = salleServiceImp.random_list_salle(filiereServiceImp.getFiliereByModule(course).getEffectif(), course.isPrise());
       Examen examen = new Examen();
       examen.setProfs(profServiceImp.random_surveillant_list(salles, course));
       examen.setCourse(course);
       examen.setSalles(salles);
        examen.setExamTime(examTimeServiceImp.random_Exam_Time());
        return examen;
    }*/

    @Override
    public Examen random_Examen(Gene gene, Module module) {
        Set<Salle> salles = salleServiceImp.random_list_salle(gene.getFiliere().getEffectif(), module.isPrise());
        Examen examen = new Examen();
        examen.setProfs(profServiceImp.random_surveillant_list(salles, module));
        examen.setModule(module);
        examen.setSalles(salles);
        examen.setExamTime(examTimeServiceImp.random_Exam_Time(gene));
        return examen;
    }

    @Override
    public Examen saveExamen(Examen examen) {
        return null;
    }
}
