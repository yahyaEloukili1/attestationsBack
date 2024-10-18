package com.example.demo.entities;

import java.util.List;



public class CustomRuelleResponse {
    private List<Ruelle> ruelles;
    private long totalElements;
	public List<Ruelle> getRuelles() {
		return ruelles;
	}
	public void setRuelles(List<Ruelle> ruelles) {
		this.ruelles = ruelles;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
    
    

 
}