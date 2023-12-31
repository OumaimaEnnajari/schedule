package com.example.edt_k.repository;

import com.example.edt_k.entity.Exam_time;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Exam_timeRepository extends CrudRepository<Exam_time,Long> {
}
