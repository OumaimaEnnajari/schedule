package com.example.edt_k.repository;

import com.example.edt_k.entity.Duration;
import com.example.edt_k.entity.Exam_Time;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Exam_timeRepository extends CrudRepository<Exam_Time,Long> {
    @Query(value = "SELECT id FROM exam_time ORDER BY RANDOM() LIMIT (select count(*) from exam_time)", nativeQuery = true)
    List<Long> getRandomIds();
    void deleteById(Long id);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM exam_time", nativeQuery = true)
    void deleteAllExamsTimes();
}
