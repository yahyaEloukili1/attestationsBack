package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
public class Ruelle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	private String designationFr;
	
	@OneToMany(mappedBy = "ruelle")
	private List<Citoyen> citoyens;
	@ManyToOne()
	 @JsonIgnore
	private Rue rue;
	
	public Ruelle() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne()

	private Quartier quartier;

	public Ruelle(String designation, String designationFr, Rue rue, Quartier quartier) {
		super();
		this.designation = designation;
		this.designationFr = designationFr;
		this.rue = rue;
		this.quartier = quartier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDesignationFr() {
		return designationFr;
	}

	public void setDesignationFr(String designationFr) {
		this.designationFr = designationFr;
	}
	@JsonIgnore
	public Rue getRue() {
		return rue;
	}
	@JsonProperty
	public void setRue(Rue rue) {
		this.rue = rue;
	}

	public Quartier getQuartier() {
		return quartier;
	}

	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

	public List<Citoyen> getCitoyens() {
		return citoyens;
	}

	
	
	
}
