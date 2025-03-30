package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class AgentAutorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;
	 @Column(unique = true)
	private String cin;
	@ManyToOne()
	@JsonIgnore	
	private Annexe annexe;
	public AgentAutorite(String nom, String cin, String prenom) {
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
	@JsonIgnore	
	private Fonction fonction;

	public AgentAutorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AgentAutorite(String nom, String prenom, Fonction fonction,Annexe annexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.annexe = annexe;
	}
@JsonIgnore
	public Annexe getAnnexe() {
		return annexe;
	}
@JsonProperty
	public void setAnnexe(Annexe annexe) {
		this.annexe = annexe;
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
	@JsonIgnore
	public Fonction getFonction() {
		return fonction;
	}
@JsonProperty
	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}


	
	
	
	
}
