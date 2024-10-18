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
public class Annexe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	private String designationFr;
	@ManyToOne()
	@JsonIgnore
	private District district;
	@ManyToOne()
	@JsonIgnore
	private Pachalik pachalik;
	@OneToMany(mappedBy = "annexe")

	private List<Endroit> endroits;
	@OneToMany(mappedBy = "annexe")

	private List<AppUser> users;
	
	@OneToMany(mappedBy = "annexe")
	
	private List<Citoyen> citoyens;
	public Annexe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Annexe(String designation ,String designationFr ,District distric) {
		super();
		
		this.designation = designation;
		this.designationFr = designationFr;
		this.district = distric;
		
	}
	
	public Annexe(String designation, String designationFr, District district, Pachalik pachalik) {
		super();
		this.designation = designation;
		this.designationFr = designationFr;
		this.district = district;
		this.pachalik = pachalik;
	}
	@JsonProperty
	public Pachalik getPachalik() {
		return pachalik;
	}
	@JsonProperty
	public void setPachalik(Pachalik pachalik) {
		this.pachalik = pachalik;
	}
	public String getDesignationFr() {
		return designationFr;
	}
	public void setDesignationFr(String designationFr) {
		this.designationFr = designationFr;
	}
	public void setUsers(List<AppUser> users) {
		this.users = users;
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
	@JsonIgnore
	public District getDistrict() {
		return district;
	}
	@JsonProperty
	public void setDistrict(District district) {
		this.district = district;
	}
	public List<Endroit> getEndroits() {
		return endroits;
	}
	public List<AppUser> getUsers() {
		return users;
	}
	
	
}
