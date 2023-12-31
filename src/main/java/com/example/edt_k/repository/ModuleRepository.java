package com.example.edt_k.repository;

import com.example.edt_k.entity.Module;
import com.example.edt_k.entity.Semestre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends CrudRepository<Module,Long> {
    List<Module> findBySemestre(Semestre semestre);
}
