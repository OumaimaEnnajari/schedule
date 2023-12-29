package com.example.edt_k.repository;

import com.example.edt_k.entity.Filiere;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.edt_k.entity.Module;
@Repository
public interface FiliereRepository extends CrudRepository<Filiere,Long> {
    Filiere findByModules(Module course);
}
