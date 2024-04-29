package com.example.edt_k.service;

import com.example.edt_k.entity.*;
import com.example.edt_k.repository.DaysRepository;
import com.example.edt_k.repository.Exam_timeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class Exam_timeServiceImp implements Exam_timeService {
    private Exam_timeRepository examTimeRepository;
    private DaysRepository daysRepository;
    private DurationServiceImp durationServiceImp;

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
    public void DeleteAllExamTimes() {
        examTimeRepository.deleteAllExamsTimes();
    }

    @Override
    public Exam_Time random_Exam_Time(Gene gene) {
        // Obtenir une liste d'IDs aléatoires
        List<Long> ListIds = random_exam_time_int();

        Random random = new Random();
        int indexAleatoire = random.nextInt(ListIds.size());
        Long idAleatoire = ListIds.get(indexAleatoire);

        //tant le exam_time est déja affécté a un exam redonnez un indice

        Exam_Time tmp = examTimeRepository.findById(idAleatoire).orElse(null);
        if(tmp != null)
        {
            boolean test=isSameExamTime(tmp,gene);
            while (test){
                indexAleatoire = random.nextInt(ListIds.size());
                idAleatoire = ListIds.get(indexAleatoire);
                tmp = examTimeRepository.findById(idAleatoire).orElse(null);
            }

        }
        //si n'est pas déja affecté

        return  tmp;
    }


    //retourne tous les ids
    @Override
    public List<Long> random_exam_time_int() {
        return examTimeRepository.getRandomIds();
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
        List<Examen> exams = gene.getExams();

        if (exams == null || exams.isEmpty()) {
            // Handle the case when exams are null or empty
            return false;
        }

        for (Examen examen : exams) {
            if (examen.getExamTime().getId() == examTime.getId()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean areExamTimesOverlapping(Exam_Time examTime1, Exam_Time examTime2) {
        boolean sameDays = examTime1.getDays().equals(examTime2.getDays());

        boolean overlapDurations = durationServiceImp.checkOverlapDurations(examTime1.getDuration(),examTime2.getDuration());

        return sameDays && overlapDurations;
    }

    @Override
    public void associateDaysWithExamTimes(List<RequestObject> requestObjects) {

        for (RequestObject object:requestObjects
        ) {
            Days day=new Days();
            day.setDate(object.getDay());
            daysRepository.save(day);
            Duration duration= new Duration();
            duration.setDebutExamen(object.getDebut());
            duration.setFinExamen(object.getFin());
            durationServiceImp.save(duration);
            Exam_Time examTime = new Exam_Time();
            examTime.setDays(day);
            examTime.setDuration(duration);
            examTimeRepository.save(examTime);
        }
    }
    @Override
    public Optional<Exam_Time> findExamTimeByid(Long id)
    {
        return examTimeRepository.findById(id);
    }
    @Override
    public void DeleteExamTimeById(Long id) {
        examTimeRepository.deleteById(id);
    }
    @Override
    public List<Exam_Time> getExam_Time() {
        return (List<Exam_Time>) examTimeRepository.findAll();
    }
}
