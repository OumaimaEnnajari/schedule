package com.example.edt_k.repository;

import com.example.edt_k.entity.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.edt_k.entity.Module;

import java.util.List;
import java.util.Optional;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere,Long> {
    Filiere findByModules(Optional<Module> course);
    @Query("SELECT f FROM Filiere f WHERE f.nom_filiere = :nomFiliere")
    Filiere chercherFiliereParNom(@Param("nomFiliere") String nomFiliere);

    @Query(value = "Select count(*) from filiere",nativeQuery = true)
    int getNbreFiliere();

    @Query("DELETE FROM Filiere WHERE nom_filiere = :nom")
    void deleteByNom(@Param("nom") String nom);


}
