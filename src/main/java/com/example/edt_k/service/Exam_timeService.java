package com.example.edt_k.service;

import com.example.edt_k.entity.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface Exam_timeService {

    Exam_Time random_Exam_Time(Gene gene);
    boolean isSameExamTime(Exam_Time examTime, Gene gene);
    void associateDaysWithExamTimes(List<RequestObject> requestObjects);
    List<Exam_Time> getExam_Time();
    Optional<Exam_Time> findExamTimeByid(Long id);
    void DeleteExamTimeById(Long id);
    boolean areExamTimesOverlapping(Exam_Time examTime1, Exam_Time examTime2);

    List<Long> random_exam_time_int();
    void DeleteAllExamTimes();

}
