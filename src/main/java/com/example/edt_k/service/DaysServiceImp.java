package com.example.edt_k.service;

import com.example.edt_k.entity.Days;
import com.example.edt_k.entity.Duration;
import com.example.edt_k.repository.DaysRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DaysServiceImp implements DaysService{
    private DaysRepository daysRepository;
    @Override
    public Days random_Day() {
        List<Days> allDays = (List<Days>) daysRepository.findAll();
        int randomIndex = CommonServices.random_int(0, allDays.size() - 1);
        return allDays.get(randomIndex);
    }
}
