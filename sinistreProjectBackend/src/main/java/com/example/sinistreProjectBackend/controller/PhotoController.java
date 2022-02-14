package com.example.sinistreProjectBackend.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.*;
import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.text.DefaultEditorKit.CopyAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ReplaceOverride;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.io.FileNotFoundException;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

import com.example.sinistreProjectBackend.model.Contrat;
import com.example.sinistreProjectBackend.model.Photo;
import com.example.sinistreProjectBackend.model.Sinistre;
import com.example.sinistreProjectBackend.service.ContratService;
import com.example.sinistreProjectBackend.service.PhotoService;
import com.example.sinistreProjectBackend.service.SinistreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/photo")
//@RequiredArgsConstructor
public class PhotoController {

	@Autowired
	PhotoService photoService;

	public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/updates/";

	@CrossOrigin
	@GetMapping("/getall")
	public List<Photo> getPhoto() {
		return photoService.getAll();
	}

	@CrossOrigin
	@GetMapping("/get/{id}")
	public Photo getPhoto(@PathVariable("id)") Long id) {
		return photoService.getPhotoById(id);
	}

	@CrossOrigin
	@DeleteMapping("delete/{id}")
	public void deletePhoto(@PathVariable("id") Long id) {
		photoService.deletePhoto(id);
	}

	@CrossOrigin
	@PostMapping("/add")
	public void addContrat(@RequestBody Photo photo) {
		photoService.addPhoto(photo);
	}

	// Define a method to upload files
	@CrossOrigin
	@PostMapping("/upload/{idSinistre}")
	public ResponseEntity<List<String>> uploadPhoto(@RequestParam("files") List<MultipartFile> multipartFiles,
			@PathVariable("idSinistre") Long idSinistre) throws IOException {
		List<String> filenames = new ArrayList<>();
		System.out.println("|");
		for (MultipartFile file : multipartFiles) {
			System.out.println("|");
			String filename = StringUtils.cleanPath(file.getOriginalFilename());
			Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
			copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
			filenames.add(filename);
			Photo photo = new Photo();
			photo.setNamePhoto(filename);
			photo.setIdSinistre(idSinistre);
			Photo p = photoService.addPhoto(photo);
		}

		return ResponseEntity.ok().body(filenames);
	}

	// Define a method to download files
	@GetMapping("download/{filename}")
	public ResponseEntity<Resource> downloadFiles(@PathVariable("filename") String filename) throws IOException {
		Path filePath = get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
		if (!Files.exists(filePath)) {
			throw new FileNotFoundException(filename + " was not found on the server");
		}
		Resource resource = new UrlResource(filePath.toUri());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("File-Name", filename);
		httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
				.headers(httpHeaders).body(resource);
	}

}