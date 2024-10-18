package com.example.demo.projections;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.entities.Annexe;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.District;
import com.example.demo.entities.Endroit;


@Projection(name = "inlinePartie4", types = { Endroit.class })
public interface EndroitProjection {

Annexe getAnnexe();
int getId();
String getIdentifiant();
String getDesignation();
String getAdress();
District getDistrict();
String getDistrictName();
String getAnnexeName();
String getCategorieName();
int getSuperficie();
String getContact();
String getObservations();
float getX();
float getY();
Categorie getCategorie();

}
