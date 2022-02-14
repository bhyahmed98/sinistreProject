package com.example.sinistreProjectBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sinistreProjectBackend.model.Contrat;
import com.example.sinistreProjectBackend.repository.ContratRepository;


@Service
public class ContratService {


	@Autowired
	private ContratRepository contratRepository;

	public List<Contrat> getAll() {
		return contratRepository.findAll();

	}

	public Contrat getContratById(Long id) {
		return contratRepository.getOne(id);
	}

	public Contrat addContrat(Contrat contrat) {
		 return contratRepository.save(contrat);
	}

	public void deleteContrat(Long id) {
		contratRepository.deleteById(id);
	}

}
