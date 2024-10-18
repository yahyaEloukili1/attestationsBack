package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fonction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	@OneToMany(mappedBy = "fonction")

	private List<AgentAutorite> agents;
	public Fonction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fonction(String designation) {
		super();
		this.designation = designation;
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
	public List<AgentAutorite> getAgents() {
		return agents;
	}
	public void setAgents(List<AgentAutorite> agents) {
		this.agents = agents;
	}

	
	
	
}
