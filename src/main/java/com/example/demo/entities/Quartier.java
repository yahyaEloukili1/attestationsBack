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



@Entity
public class Quartier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	private String designationFr;
	public List<Citoyen> getCitoyens() {
		return citoyens;
	}

	@OneToMany(mappedBy = "quartier")
	private List<Citoyen> citoyens;
	@OneToMany(mappedBy = "quartier")
	
	private List<Rue> rues;
	
	@OneToMany(mappedBy = "quartier")
	
	private List<Ruelle> rueeles;

	public Quartier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quartier(String designation, String designationFr, List<Rue> rues, List<Ruelle> rueeles) {
		super();
		this.designation = designation;
		this.designationFr = designationFr;
		this.rues = rues;
		this.rueeles = rueeles;
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

	public List<Rue> getRues() {
		return rues;
	}

	public void setRues(List<Rue> rues) {
		this.rues = rues;
	}

	public List<Ruelle> getRueeles() {
		return rueeles;
	}

	public void setRueeles(List<Ruelle> rueeles) {
		this.rueeles = rueeles;
	}
	
	
	
	
}
