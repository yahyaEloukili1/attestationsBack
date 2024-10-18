package com.example.demo.entities;

import java.util.List;



public class CustomUserResponse {
    private List<AppUser> users;
    private long totalElements;
	public List<AppUser> getUsers() {
		return users;
	}
	public void setAppUsers(List<AppUser> users) {
		this.users = users;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
    
    

 
}