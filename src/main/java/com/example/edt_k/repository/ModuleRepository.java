package com.example.edt_k.repository;

import com.example.edt_k.Json_Object.ModuleObject;
import com.example.edt_k.entity.Filiere;
import com.example.edt_k.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModuleRepository extends JpaRepository<Module,Long> {

    List<Module> findByFiliere(Filiere filiere);
    @Query("SELECT m FROM Module m JOIN FETCH m.prof JOIN FETCH m.filiere")
    List<Module> findAllWithDetails();
    @Modifying
    @Transactional
    @Query("DELETE FROM Module WHERE nom = :nom")
    void deleteByNom(@Param("nom") String nom);
}
