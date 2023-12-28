package com.example.edt_k.repository;

import com.example.edt_k.entity.Salle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends CrudRepository<Salle,Long> {
}
