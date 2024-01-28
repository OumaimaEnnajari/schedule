package com.example.edt_k.service;

import com.example.edt_k.entity.Duration;
import com.example.edt_k.repository.DurationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DurationServiceImp implements DurationService{
    private DurationRepository durationRepository;
    @Override
    public Duration random_Duration() {
        List<Duration> allDurations = (List<Duration>) durationRepository.findAll();
        // Choisir aleatoirement
        int randomIndex = CommonServices.random_int(0, allDurations.size() - 1);
        return allDurations.get(randomIndex);
    }
}
