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
public class Rue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	private String designationFr;
	@OneToMany(mappedBy = "rue")
	private List<Citoyen> citoyens;
	@ManyToOne()
	@JsonIgnore
	private Quartier quartier;

	public Rue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rue(String designation, String designationFr, Quartier quartier) {
		super();
		this.designation = designation;
		this.designationFr = designationFr;
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
	public Quartier getQuartier() {
		return quartier;
	}
@JsonProperty
	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

public List<Citoyen> getCitoyens() {
	return citoyens;
}



	
}
