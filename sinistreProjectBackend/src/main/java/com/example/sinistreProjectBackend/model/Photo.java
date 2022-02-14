package com.example.sinistreProjectBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "photo")
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "photo_seq")
	@SequenceGenerator(name = "Photo_seq", sequenceName = "Photo_seq")
	private long idPhoto;
	private long idSinistre;
	private String namePhoto;
	
	
	
	public long getIdPhoto() {
		return idPhoto;
	}
	public void setIdPhoto(long idPhoto) {
		this.idPhoto = idPhoto;
	}
	public long getIdSinistre() {
		return idSinistre;
	}
	public void setIdSinistre(long idSinistre) {
		this.idSinistre = idSinistre;
	}
	public String getNamePhoto() {
		return namePhoto;
	}
	public void setNamePhoto(String namePhoto) {
		this.namePhoto = namePhoto;
	}
	
}
