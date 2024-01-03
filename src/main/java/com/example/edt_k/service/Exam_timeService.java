package com.example.edt_k.service;

import com.example.edt_k.entity.Exam_time;
import com.example.edt_k.entity.Gene;

public interface Exam_timeService {

    Exam_time random_Exam_Time(Gene gene);
    boolean isSameExamTime(Exam_time examTime, Gene gene);
}
