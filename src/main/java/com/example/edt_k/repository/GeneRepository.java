package com.example.edt_k.repository;

import com.example.edt_k.entity.Gene;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneRepository extends CrudRepository<Gene,Long> {
}
