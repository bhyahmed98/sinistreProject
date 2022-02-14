package com.example.sinistreProjectBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.sinistreProjectBackend.model.Contrat;
import com.example.sinistreProjectBackend.model.Sinistre;
import com.example.sinistreProjectBackend.service.ContratService;
import com.example.sinistreProjectBackend.service.SinistreService;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/sinistre")
//@RequiredArgsConstructor
public class SinistreController {

	@Autowired
	SinistreService sinistreService;

	
	@GetMapping("/getall")
	public List<Sinistre> getSinistre() {
		return sinistreService.getAll();
	}


	@GetMapping("/get/{id}")
	public Sinistre getSinistre(@PathVariable("id)") Long id) {
		return sinistreService.getSinistreById(id);
	}

	
	@DeleteMapping("delete/{id}")
	public void deleteSinistre(@PathVariable("id") Long id) {
		 sinistreService.deleteSinistre(id);
	}

	
	@PostMapping("/add")
	public Sinistre addSinistre(@RequestBody Sinistre sinistre) {
		return sinistreService.addSinistre(sinistre);
	}

}