package com.example.edt_k.repository;

import com.example.edt_k.entity.Days;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaysRepository extends CrudRepository<Days,Long> {
    @Query(value = "Select count(*) from days",nativeQuery = true)
    int getNbreDays();
}
