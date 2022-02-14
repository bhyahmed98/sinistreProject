package com.example.sinistreProjectBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sinistreProjectBackend.model.Photo;
import com.example.sinistreProjectBackend.model.Sinistre;
import com.example.sinistreProjectBackend.repository.PhotoRepository;
import com.example.sinistreProjectBackend.repository.SinistreRepository;



@Service
public class PhotoService {


	@Autowired
	private PhotoRepository photoRepository;

	public List<Photo> getAll() {
		return photoRepository.findAll();

	}

	public Photo getPhotoById(Long id) {
		return photoRepository.getOne(id);
	}

	public Photo addPhoto(Photo photo) {
		return photoRepository.save(photo);
	}

	public void deletePhoto(Long id) {
		photoRepository.deleteById(id);
	}



}