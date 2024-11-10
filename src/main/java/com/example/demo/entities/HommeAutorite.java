package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class HommeAutorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;
	private String cin;
	
	public HommeAutorite(String nom, String cin, String prenom) {
		super();
		this.nom = nom;
		this.cin = cin;
		this.prenom = prenom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	private String prenom;
	@ManyToOne()
	
	private FonctionHommeAUtorite fonctionHommeAUtorite;

	public HommeAutorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public HommeAutorite(String nom, String cin, String prenom, FonctionHommeAUtorite fonctionHommeAUtorite) {
		super();
		this.nom = nom;
		this.cin = cin;
		this.prenom = prenom;
		this.fonctionHommeAUtorite = fonctionHommeAUtorite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public FonctionHommeAUtorite getFonctionHommeAUtorite() {
		return fonctionHommeAUtorite;
	}

	public void setFonctionHommeAUtorite(FonctionHommeAUtorite fonctionHommeAUtorite) {
		this.fonctionHommeAUtorite = fonctionHommeAUtorite;
	}



	
	
	
	
}
