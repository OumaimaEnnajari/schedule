package com.example.edt_k.repository;

import com.example.edt_k.entity.Module;
import com.example.edt_k.entity.Prof;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProfRepository extends CrudRepository<Prof,Long>, JpaRepository<Prof,Long> {
    Optional<Prof> findProfByModules(Optional<Module> module);
    @Query("select p from Prof p where p.nom like :x ")
    List<Prof> chercherprof(@Param("x") String mc);

    Set<Prof> findByExamens_Id(Long examenId);
    Optional<Prof> findByNom(String nom);
    Optional<Prof> findById(Long id);

    @Query("SELECT p FROM Prof p WHERE p.user.id = :x")
    Optional<Prof> findProfByidUser(@Param("x") Long x);

    @Query("SELECT p FROM Prof p WHERE p.PPR = :PPR")
    Optional<Prof> getProfByPPR(@Param("PPR") String PPR);

    @Modifying
    @Transactional
    @Query("DELETE FROM Prof p WHERE p.PPR = :PPR")
    void supprimerParPPR(@Param("PPR") String PPR);

}
