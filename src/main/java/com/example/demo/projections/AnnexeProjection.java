package com.example.demo.projections;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.entities.Annexe;
import com.example.demo.entities.District;



@Projection(name = "inlinePartie2", types = { Annexe.class })
public interface AnnexeProjection {

	int getId();
	String getDesignation();
	String getDesignationFr();
	District getDistrict();
}
