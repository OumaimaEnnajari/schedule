package com.example.edt_k.repository;

import com.example.edt_k.entity.Module;
import com.example.edt_k.entity.Prof;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfRepository extends CrudRepository<Prof,Long> {
    Optional<Prof> findProfByModules(Module module);
}
