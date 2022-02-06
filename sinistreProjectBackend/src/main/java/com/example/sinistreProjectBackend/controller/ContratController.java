package com.example.sinistreProjectBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.sinistreProjectBackend.model.Contrat;
import com.example.sinistreProjectBackend.service.ContratService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contrat")
//@RequiredArgsConstructor
public class ContratController {

	@Autowired
	ContratService contratService;

	@CrossOrigin
	@GetMapping("/getall")
	public List<Contrat> getContrat() {
		return contratService.getAll();
	}

	@CrossOrigin
	@GetMapping("/get/{id}")
	public Contrat getContrat(@PathVariable("id)") Long id) {
		return contratService.getContratById(id);
	}

	@CrossOrigin
	@DeleteMapping("delete/{id}")
	public void deleteContrat(@PathVariable("id") Long id) {
		contratService.deleteContrat(id);
	}

	@CrossOrigin
	@PostMapping("/add")
	public void addContrat(@RequestBody Contrat contrat) {
		contratService.addContrat(contrat);
	}

}
