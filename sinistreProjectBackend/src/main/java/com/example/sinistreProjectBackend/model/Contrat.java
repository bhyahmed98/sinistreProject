package com.example.sinistreProjectBackend.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "contrat")
public class Contrat {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contrat_seq")
	@SequenceGenerator(name = "contrat_seq", sequenceName = "contrat_seq")
	private long numeroContrat;
	private String dateDebut;
	private String dateFin;
	private String nomAssure;
	private String immatriculation;

	// @OneToMany(fetch = FetchType.EAGER,mappedBy="idContrat")
	// private Set<Sinistre> sinistres;

	public long getNumeroContrat() {
		return numeroContrat;
	}

	public void setNumeroContrat(long numeroContrat) {
		this.numeroContrat = numeroContrat;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getNomAssure() {
		return nomAssure;
	}

	public void setNomAssure(String nomAssure) {
		this.nomAssure = nomAssure;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

}
