package com.example.edt_k.service;

import com.example.edt_k.entity.Exam_time;
import com.example.edt_k.entity.Gene;
import com.example.edt_k.repository.Exam_timeRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Lazy
public class Exam_timeServiceImp implements Exam_timeService {
    private Exam_timeRepository examTimeRepository;
    private ExamenServiceImp examenerviceImp;



    //on doit loop sur tous les exam_time et voir si cette exam est déja affecté ou pas
   /* @Override
    public Exam_time random_Exam_Time() {
        //donner un indice aléatoire
        int i = CommonServices.random_int(0,getExam_Times().size());
        //tant le exam_time est déja affécté a un exam redonnez un indice
        while (examenerviceImp.isSameExamTime(getExam_Times().get(i))){
            i = CommonServices.random_int(0,getExam_Times().size());
        }
        //si n'est pas déja affecté
        return getExam_Times().get(i);
    }*/

    @Override
    public Exam_time random_Exam_Time(Gene gene) {
        //donner un indice aléatoire
        int i = CommonServices.random_int(0,gene.getmeetingtimes().size());
        //tant le exam_time est déja affécté a un exam redonnez un indice
        while (examenerviceImp.isSameExamTime(gene.getmeetingtimes().get(i),gene)){
            i = CommonServices.random_int(0,gene.getmeetingtimes().size());
        }
        //si n'est pas déja affecté
        return gene.getmeetingtimes().get(i);
    }
}