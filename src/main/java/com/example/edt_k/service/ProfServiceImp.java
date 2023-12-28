package com.example.edt_k.service;

import com.example.edt_k.entity.Prof;
import com.example.edt_k.repository.ProfRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfServiceImp implements ProfService{
    private ProfRepository profRepository;
    private ModuleServiceImp moduleServiceImp;
    @Override
    public List<Prof> getProfs() {
        return (List<Prof>) profRepository.findAll();
    }

    @Override
    public Prof random_surveillant(Module module) {
        int i = CommonServices.random_int(0,getProfs().size());
        //le prof qui enseigne le module ne doit pas surveiller
        //
        while (getProfs().get(i)==moduleServiceImp.getProfByModule(module)){
            i = CommonServices.random_int(0,getProfs().size());
        }
        return getProfs().get(i);
    }
}
