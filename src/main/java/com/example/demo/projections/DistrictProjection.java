package com.example.demo.projections;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.entities.Annexe;
import com.example.demo.entities.District;
import com.example.demo.entities.Pachalik;



@Projection(name = "inlinePartie3", types = { District.class })
public interface DistrictProjection {

	int getId();
	String getDesignation();
	String getDesignationFr();
	Pachalik getPachalik();
}
