package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	private String designationFr;
	@OneToMany(mappedBy = "district")

	private List<Annexe> annexes;
	
	@OneToMany(mappedBy = "annexe")
	
	private List<AppUser> appUsers;
	
	public List<AppUser> getAppUsers() {
		return appUsers;
	}



	public void setAppUsers(List<AppUser> appUsers) {
		this.appUsers = appUsers;
	}


	@ManyToOne()
	@JsonIgnore
	private Pachalik pachalik;
	@JsonIgnore
	public Pachalik getPachalik() {
		return pachalik;
	}


	@JsonProperty
	public void setPachalik(Pachalik pachalik) {
		this.pachalik = pachalik;
	}



	public District() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public String getDesignationFr() {
		return designationFr;
	}



	public void setDesignationFr(String designationFr) {
		this.designationFr = designationFr;
	}



	public List<Annexe> getAnnexes() {
		return annexes;
	}



	public District(String designation, String designationFr) {
		super();
		this.designation = designation;
		this.designationFr = designationFr;
	}



	public District(String designation, String designationFr, Pachalik pachalik) {
		super();
		this.designation = designation;
		this.designationFr = designationFr;
		this.pachalik = pachalik;
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


	public void setAnnexes(List<Annexe> annexes) {
		this.annexes = annexes;
	}
	
	
}
