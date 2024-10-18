package com.example.demo.entities;

import java.util.List;



public class CustomRueResponse {
    private List<Rue> rues;
    private long totalElements;
	public List<Rue> getRues() {
		return rues;
	}
	public void setRues(List<Rue> rues) {
		this.rues = rues;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
    
    

 
}