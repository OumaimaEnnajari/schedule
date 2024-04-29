package com.example.edt_k.repository;

import com.example.edt_k.entity.Duration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DurationRepository extends CrudRepository<Duration,Long> {
    @Query(value = "Select count(*) from duration",nativeQuery = true)
    int getNbreDuration();
    @Query("SELECT d FROM Duration d WHERE d.debutExamen = :fin AND d.FinExamen = :debut")
    Optional<Duration> findByDebutFin(@Param("debut") String debut, @Param("fin") String fin);

}
