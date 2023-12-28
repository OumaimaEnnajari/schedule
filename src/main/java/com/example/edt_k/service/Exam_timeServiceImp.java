package com.example.edt_k.service;

import com.example.edt_k.entity.Exam_time;
import com.example.edt_k.repository.Exam_timeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Exam_timeServiceImp implements Exam_timeService {
    private Exam_timeRepository examTimeRepository;
    private ExamenerviceImp examenerviceImp;
    @Override
    public List<Exam_time> getExam_Times() {
        return (List<Exam_time>) examTimeRepository.findAll();
    }

    //on doit loop sur tous les exam_time et voir si cette exam est déja affecté ou pas
    @Override
    public Exam_time random_Exam_Time() {
        //donner un indice aléatoire
        int i = CommonServices.random_int(0,getExam_Times().size());
        //tant le exam_time est déja affécté a un exam redonnez un indice
        while (examenerviceImp.isSameExamTime(getExam_Times().get(i))){
            i = CommonServices.random_int(0,getExam_Times().size());
        }
        //si n'est pas déja affecté
        return getExam_Times().get(i);
    }
}