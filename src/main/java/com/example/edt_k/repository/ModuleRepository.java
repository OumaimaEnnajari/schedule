package com.example.edt_k.repository;

import com.example.edt_k.entity.Module;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends CrudRepository<Module,Long> {
}
