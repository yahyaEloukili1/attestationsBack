package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AppRole {
	
	@Id
	private Integer id;
	private String roleName;
	private String roleNameAr;

	public String getRoleNameAr() {
		return roleNameAr;
	}
	public void setRoleNameAr(String roleNameAr) {
		this.roleNameAr = roleNameAr;
	}
	@OneToMany(mappedBy = "role")
	private List<AppUser> users;
	

	public AppRole(Integer id, String roleName, String roleNameAr) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.roleNameAr = roleNameAr;
		
	}
	public AppRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<AppUser> getUsers() {
		return users;
	}
	public void setUsers(List<AppUser> users) {
		this.users = users;
	}
	
	
}
