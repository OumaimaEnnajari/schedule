package com.example.edt_k.service;

import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Module;
import com.example.edt_k.repository.FiliereRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FiliereServiceImp implements FiliereService{
    private FiliereRepository filiereRepository;
    @Override
    public Filiere getFiliereByModule(Module course) {
        return filiereRepository.findByModules(course);
    }

    @Override
    public List<Filiere> getFiliere() {
        return filiereRepository.findAll();
    }

}
