package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Pachalik {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	private String designationFr;
	@OneToMany(mappedBy = "pachalik")

	private List<Annexe> annexes;
	@OneToMany(mappedBy = "pachalik")

	private List<District> districts;
	
	@OneToMany(mappedBy = "pachalik")
	private List<AppUser> users;
	
	
	public List<AppUser> getUsers() {
		return users;
	}



	public void setUsers(List<AppUser> users) {
		this.users = users;
	}



	public Pachalik() {
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



	public Pachalik(String designation, String designationFr) {
		super();
		this.designation = designation;
		this.designationFr = designationFr;
	}



	public List<District> getDistricts() {
		return districts;
	}



	public void setDistricts(List<District> districts) {
		this.districts = districts;
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
