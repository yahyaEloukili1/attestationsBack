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
public class Sex {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String designation;
	
	@OneToMany(mappedBy = "sex")
	private List<Citoyen> citoyens;


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


	public Sex() {
		super();
	
	}


	public Sex(String designation) {
		super();
		this.designation = designation;
	
	}
	
}
