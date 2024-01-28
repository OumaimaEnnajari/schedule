package com.example.edt_k.repository;

import com.example.edt_k.entity.Duration;
import com.example.edt_k.entity.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamenRepository extends JpaRepository<Examen,Long> {
    //return all the exams at this exam time
    List<Examen> findByExamTime(Duration examTime);

}
