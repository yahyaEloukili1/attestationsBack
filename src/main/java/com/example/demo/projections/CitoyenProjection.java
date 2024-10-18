package com.example.demo.projections;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.entities.Annexe;
import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.Citoyen;
import com.example.demo.entities.District;
import com.example.demo.entities.Pachalik;
import com.example.demo.entities.Quartier;
import com.example.demo.entities.Rue;
import com.example.demo.entities.Ruelle;
import com.example.demo.entities.Sex;
import com.example.demo.entities.Situation;

@Projection(name = "inlinePartieCitoyen", types = { Citoyen.class })
public interface CitoyenProjection {

	Integer getId();
	
	
	Annexe getAnnexe();
	Pachalik getPachalik();
	District getDistrict();
	
	 String getFirstNameAr();
	 String getFirstNameFr();
	 Quartier getQuartier();
	 Rue getRue();
	 Ruelle getRuelle();
	String getLastNameAr();
	String getLastNameFr();

	 String getEmail();
	 String getCin();
	 String getPhone();
	 String getJob();


	 
	String getPhotoName();

	 String getCin1();
	 String getCin2();
	 String getActeNaissance();
	 
		 String getCity();
		 Date getDateOfBirth();
		 String getPasseportId();
		 String getTown();
		 Sex getSex();
		 Situation getSituation();
	
	
	
}
