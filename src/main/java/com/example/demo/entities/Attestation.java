package com.example.demo.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Attestation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne()
	@JsonIgnore	
	private Citoyen citoyen;
	private String cin;

	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	@ManyToOne()
	@JsonIgnore	
	private TypeAttestation typeAttestation;

	@ManyToOne
	@JsonIgnore	
	private AgentAutorite agentAutorite;

	private String but;
	@CreationTimestamp
	private Date createdAt;
	public Attestation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Attestation(Citoyen citoyen, TypeAttestation type, AgentAutorite agentAutorite, String but, Date createdAt) {
		super();
		this.citoyen = citoyen;
		this.typeAttestation = type;
		this.agentAutorite = agentAutorite;
		this.but = but;
		this.createdAt = createdAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonIgnore
	public Citoyen getCitoyen() {
		return citoyen;
	}
	@JsonProperty
	public void setCitoyen(Citoyen citoyen) {
		this.citoyen = citoyen;
	}
	@JsonIgnore
	public TypeAttestation getTypeAttestation() {
		return typeAttestation;
	}
	@JsonProperty
	public void setTypeAttestation(TypeAttestation typeAttestation) {
		this.typeAttestation = typeAttestation;
	}
	@JsonIgnore
	public AgentAutorite getAgentAutorite() {
		return agentAutorite;
	}
	@JsonProperty
	public void setAgentAutorite(AgentAutorite agentAutorite) {
		this.agentAutorite = agentAutorite;
	}
	public String getBut() {
		return this.but;
	}
	public void setBut(String but) {
		this.but = but;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
}
