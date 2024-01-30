package com.example.edt_k.service;

import com.example.edt_k.entity.*;
import com.example.edt_k.repository.DaysRepository;
import com.example.edt_k.repository.DurationRepository;
import com.example.edt_k.repository.Exam_timeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class Exam_timeServiceImp implements Exam_timeService {
    private Exam_timeRepository examTimeRepository;
    private DaysRepository daysRepository;
    private DurationRepository durationRepository;

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
    public Exam_Time random_Exam_Time(Gene gene) {
        //donner un indice aléatoire
        int  i = CommonServices.random_int(2, (int) examTimeRepository.count());
        //tant le exam_time est déja affécté a un exam redonnez un indice
        while (isSameExamTime(examTimeRepository.findById((long) i).get(),gene)){
            i = CommonServices.random_int(2,(int) examTimeRepository.count());
        }
        //si n'est pas déja affecté
        return examTimeRepository.findById((long) i).get();
    }

    /*@Override
    public Exam_Time random_Exam_Time(Gene gene) {
        Duration duration = durationServiceImp.random_Duration();
        Days days = daysServiceImp.random_Day();
        Exam_Time examTime = new Exam_Time();
        examTime.setDuration(duration);
        examTime.setDays(days);
        return examTime;
    }*/

    @Override
    public boolean isSameExamTime(Exam_Time examTime, Gene gene) {
        for (Examen examen : gene.getExams()
        ) {
            if(examen.getExamTime().equals(examTime))
                return true;
        }
        return false;
    }

    @Override
    public List<Exam_Time> associateDaysWithExamTimes(List<Days> daysList, List<Duration> durationList) {
        List<Exam_Time> examTimes = new ArrayList<>();

        for (Days day : daysList) {
            for (Duration duration : durationList) {
                daysRepository.save(day);
                durationRepository.save(duration);

                // Creer nvl exam time pour chaque combinaison
                Exam_Time examTime = new Exam_Time();
                examTime.setDays(day);
                examTime.setDuration(duration);

                // Save l'exam time ds bdd
                examTimes.add(examTimeRepository.save(examTime));
            }
        }

        return examTimes;
    }

    @Override
    public List<Exam_Time> getExam_Time() {
        return (List<Exam_Time>) examTimeRepository.findAll();
    }
}
