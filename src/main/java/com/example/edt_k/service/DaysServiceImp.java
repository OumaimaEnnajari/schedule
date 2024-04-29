package com.example.edt_k.service;

import com.example.edt_k.entity.Days;
import com.example.edt_k.entity.Duration;
import com.example.edt_k.repository.DaysRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Override
    public Days updateDays(Long id, Days newDay) {
        Days day=daysRepository.findById(id).orElse(null);
        day.setDate(newDay.getDate());
        return daysRepository.save(day);
    }
    @Override
    public void DeleteDay(Days day) {
        daysRepository.deleteById(day.getId());
    }

    @Override
    public List<Days> getDays() {
        return (List<Days>) daysRepository.findAll();
    }

    @Override
    public int countDays() {
        return daysRepository.getNbreDays();
    }

    @Override
    public void Alldeleted() {
        daysRepository.deleteAll();
    }

}
