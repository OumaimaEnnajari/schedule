package com.example.edt_k.service;

import com.example.edt_k.entity.Days;
import com.example.edt_k.entity.Duration;
import com.example.edt_k.entity.Exam_Time;
import com.example.edt_k.entity.Gene;

import java.util.List;

public interface Exam_timeService {

   Exam_Time random_Exam_Time(Gene gene);
    boolean isSameExamTime(Exam_Time examTime, Gene gene);
    Exam_Time associateDaysWithExamTimes(List<Days> daysList, List<Duration> durationList);
}
