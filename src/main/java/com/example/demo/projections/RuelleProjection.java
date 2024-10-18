package com.example.demo.projections;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.entities.Annexe;
import com.example.demo.entities.District;
import com.example.demo.entities.Pachalik;
import com.example.demo.entities.Quartier;
import com.example.demo.entities.Rue;
import com.example.demo.entities.Ruelle;



@Projection(name = "inlinePartie5", types = { Ruelle.class })
public interface RuelleProjection {

	int getId();
	String getDesignation();
	String getDesignationFr();
	Rue getRue();
	Quartier getQuartier();
}
