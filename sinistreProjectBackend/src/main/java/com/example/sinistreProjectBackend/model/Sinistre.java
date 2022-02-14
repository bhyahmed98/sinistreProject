package com.example.sinistreProjectBackend.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "sinistre")
public class Sinistre {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sinistre_seq")
	@SequenceGenerator(name = "sinistre_seq", sequenceName = "sinistre_seq")
	private long numeroSinistre;
	private String dateAccident;
	private String dateCreation;
	private String statut;
	//private long idContrat;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "idSinistre")
	private Set<Photo> photos;

	@OneToOne(cascade = CascadeType.ALL)

	public long getNumeroSinistre() {
		return numeroSinistre;
	}

	public void setNumeroSinistre(long numeroSinistre) {
		this.numeroSinistre = numeroSinistre;
	}

	public String getDateAccident() {
		return dateAccident;
	}

	public void setDateAccident(String dateAccident) {
		this.dateAccident = dateAccident;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

}
