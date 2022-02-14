package com.example.sinistreProjectBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sinistreProjectBackend.model.Admin;
import com.example.sinistreProjectBackend.model.Contrat;
import com.example.sinistreProjectBackend.service.AdminService;
import com.example.sinistreProjectBackend.service.ContratService;

@CrossOrigin
@RestController
@RequestMapping("/admin")
//@RequiredArgsConstructor
public class AdminController {

	@Autowired
	AdminService adminService;

	
	@GetMapping("/getall")
	public List<Admin> getContrat() {
		return adminService.getAll();
	}

	
	@GetMapping("/get/{id}")
	public Admin getAdmin(@PathVariable("id)") Long id) {
		return adminService.getAdminById(id);
	}

	
	@DeleteMapping("delete/{id}")
	public void deleteAdmin(@PathVariable("id") Long id) {
		adminService.deleteAdmin(id);
	}

	
	@PostMapping("/add")
	public void addContrat(@RequestBody Admin admin) {
		adminService.addAdmin(admin);
	}

}