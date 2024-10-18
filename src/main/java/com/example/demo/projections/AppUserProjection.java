package com.example.demo.projections;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.entities.Annexe;
import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.District;
import com.example.demo.entities.Pachalik;



@Projection(name = "inlinePartie4", types = { AppUser.class })
public interface AppUserProjection {

	int getId();
	
	AppRole getRole();
	Annexe getAnnexe();
	Pachalik getPachalik();
	District getDistrict();
	
	 String getFirstNameAr();
	 String getFirstNameFr();
	 
	String getLastNameAr();
	String getLastNameFr();
	String getPassword();
	 String getEmail();
	 String getCin();
	 String getPhone();
	 String getJob();
	String getJobPlace();
	String getUsername();
	String getPhotoName();
	
}
