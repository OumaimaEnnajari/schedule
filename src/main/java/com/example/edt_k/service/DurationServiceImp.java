package com.example.edt_k.service;

import com.example.edt_k.entity.Days;
import com.example.edt_k.entity.Duration;
import com.example.edt_k.entity.Salle;
import com.example.edt_k.repository.DaysRepository;
import com.example.edt_k.repository.DurationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class DurationServiceImp implements DurationService{
    private DurationRepository durationRepository;

    @Override
    public Duration findDurationById(Long id) {
        return durationRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimertous() {
        durationRepository.deleteAll();
    }

    @Override
    public Duration updateDuration(Long id, Duration newDuration) {
        Duration duration=durationRepository.findById(id).orElse(null);
        duration.setDebutExamen(newDuration.getDebutExamen());
        duration.setFinExamen(newDuration.getFinExamen());
        return durationRepository.save(duration);
    }

    @Override
    public int countDuration() {
        return durationRepository.getNbreDuration();
    }


    @Override
    public List<Duration> getDurations() {
        return (List<Duration>) durationRepository.findAll();
    }

    @Override
    public Optional<Duration> findDurationByDebutAndFin(String debutExamen, String finExamen) {
        return durationRepository.findByDebutFin(debutExamen, finExamen);
    }
    @Override
    public void deleteDuration(long id) {
        durationRepository.deleteById(id);
    }
    @Override
    public Duration save(Duration duration) {
        return durationRepository.save(duration);
    }

    @Override
    public boolean checkOverlapDurations(Duration duration1, Duration duration2) {
        LocalDateTime debutExamen1 = LocalDateTime.parse(duration1.getDebutExamen());
        LocalDateTime finExamen1 = LocalDateTime.parse(duration1.getFinExamen());

        LocalDateTime debutExamen2 = LocalDateTime.parse(duration2.getDebutExamen());
        LocalDateTime finExamen2 = LocalDateTime.parse(duration2.getFinExamen());

        return (debutExamen1.isBefore(debutExamen2) && finExamen1.isBefore(finExamen2) ||
                debutExamen1.isAfter(debutExamen2) && finExamen1.isAfter(finExamen2));}
}
