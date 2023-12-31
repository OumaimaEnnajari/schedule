package com.example.edt_k.repository;

import com.example.edt_k.entity.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.edt_k.entity.Module;

import java.util.List;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere,Long> {
    Filiere findByModules(Module course);
}
