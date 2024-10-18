package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Situation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	@OneToMany(mappedBy = "situation")
	private List<Citoyen> citoyens;

private String designation;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<Citoyen> getCitoyens() {
		return citoyens;
	}


	public void setCitoyens(List<Citoyen> citoyens) {
		this.citoyens = citoyens;
	}


	public Situation() {
		super();
	
	}


	public Situation(String designation) {
		super();
		
		this.designation = designation;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
