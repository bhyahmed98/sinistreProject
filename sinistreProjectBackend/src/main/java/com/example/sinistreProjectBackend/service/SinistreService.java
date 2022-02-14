package com.example.sinistreProjectBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sinistreProjectBackend.model.Contrat;
import com.example.sinistreProjectBackend.model.Sinistre;
import com.example.sinistreProjectBackend.repository.ContratRepository;
import com.example.sinistreProjectBackend.repository.SinistreRepository;

@Service
public class SinistreService {


	@Autowired
	private SinistreRepository sinistreRepository;

	public List<Sinistre> getAll() {
		return sinistreRepository.findAll();

	}

	public Sinistre getSinistreById(Long id) {
		return sinistreRepository.getOne(id);
	}

	public Sinistre addSinistre(Sinistre sinistre) {
		return sinistreRepository.save(sinistre);
	}

	public void deleteSinistre(Long id) {
		sinistreRepository.deleteById(id);
	}



}