package com.example.edt_k.repository;

import com.example.edt_k.entity.Exam_time;
import com.example.edt_k.entity.Examen;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExamenRepository extends CrudRepository<Examen,Long> {
    //return all the exams at this exam time
    List<Examen> findByExamTime(Exam_time examTime);
}
