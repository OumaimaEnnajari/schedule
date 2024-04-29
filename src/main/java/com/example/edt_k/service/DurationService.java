package com.example.edt_k.service;

import com.example.edt_k.entity.Days;
import com.example.edt_k.entity.Duration;
import com.example.edt_k.entity.Salle;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DurationService {
    Optional<Duration> findDurationByDebutAndFin(String debutExamen, String finExamen);
    Duration save(Duration duration);

    boolean checkOverlapDurations(Duration duration1, Duration duration2);
    Duration findDurationById(Long id);
    void supprimertous();
    Duration updateDuration(Long id, Duration newDuration);

    List<Duration> getDurations();
    void deleteDuration(long id);

    int countDuration();
}
