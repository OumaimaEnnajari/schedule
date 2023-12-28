package com.example.edt_k.repository;

import com.example.edt_k.entity.Prof;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModuleRepository extends CrudRepository<Module,Long> {
    //find the professor that teach the module
    Optional<Prof> findProfByModule(Module module);
}
