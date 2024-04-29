package com.example.edt_k.service;

import com.example.edt_k.entity.Days;
import com.example.edt_k.entity.Duration;

import java.util.List;
import java.util.Set;

public interface DaysService {
    public Days random_Day();
    Days updateDays(Long id, Days newDay);
    void DeleteDay(Days day);
    List<Days> getDays();
    void Alldeleted();
    int countDays();
}
