package com.example.sinistreProjectBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sinistreProjectBackend.model.Admin;
import com.example.sinistreProjectBackend.model.Contrat;
import com.example.sinistreProjectBackend.repository.AdminRepository;
import com.example.sinistreProjectBackend.repository.ContratRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public List<Admin> getAll() {
		return adminRepository.findAll();

	}

	public Admin getAdminById(Long id) {
		return adminRepository.getOne(id);
	}

	public void addAdmin(Admin admin) {
		adminRepository.save(admin);
	}

	public void deleteAdmin(Long id) {
		adminRepository.deleteById(id);
	}

}
