package com.example.demo.projections;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.entities.Annexe;
import com.example.demo.entities.District;
import com.example.demo.entities.Pachalik;
import com.example.demo.entities.Quartier;
import com.example.demo.entities.Rue;



@Projection(name = "inlinePartie5", types = { Rue.class })
public interface RueProjection {

	int getId();
	String getDesignation();
	String getDesignationFr();
	Quartier getQuartier();
}
