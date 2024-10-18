package com.example.demo.entities;

import java.util.List;



public class CustomAnnexeResponse {
    private List<Annexe> annexes;
    private long totalElements;
	public List<Annexe> getAnnexes() {
		return annexes;
	}
	public void setAnnexes(List<Annexe> annexes) {
		this.annexes = annexes;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
    
    

 
}