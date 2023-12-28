package com.example.edt_k.service;

import com.example.edt_k.entity.Exam_time;
import com.example.edt_k.entity.Examen;
import com.example.edt_k.exception.EntityNotFoundException;
import com.example.edt_k.repository.ExamenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExamenerviceImp implements ExamenService {
    private ExamenRepository examenRepository;

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

}
