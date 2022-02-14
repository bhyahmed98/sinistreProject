package com.example.sinistreProjectBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sinistreProjectBackend.model.Photo;
import com.example.sinistreProjectBackend.model.Sinistre;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

}