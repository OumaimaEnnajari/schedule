package com.example.edt_k.repository;

import com.example.edt_k.entity.Duration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DurationRepository extends CrudRepository<Duration,Long> {
}
