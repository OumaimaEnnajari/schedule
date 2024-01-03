package com.example.edt_k.service;

import com.example.edt_k.entity.Semestre;
import com.example.edt_k.repository.SemestreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SemestreServiceImp implements  SemestreService{
    private SemestreRepository semestreRepository;


    @Override
    public Optional<Semestre> getSemestreById(Long id) {
        return semestreRepository.findById(id);
    }
}
