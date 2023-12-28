package com.example.edt_k.service;

import com.example.edt_k.entity.Exam_time;

import java.util.List;

public interface Exam_timeService {
    List<Exam_time> getExam_Times();
    Exam_time random_Exam_Time();

}
