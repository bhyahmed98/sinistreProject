package com.example.sinistreProjectBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sinistreProjectBackend.model.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {

}
