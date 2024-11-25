package com.example.demo.projections;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.entities.AgentAutorite;
import com.example.demo.entities.Annexe;
import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.Attestation;
import com.example.demo.entities.Citoyen;
import com.example.demo.entities.District;
import com.example.demo.entities.Pachalik;
import com.example.demo.entities.Quartier;
import com.example.demo.entities.Rue;
import com.example.demo.entities.Ruelle;
import com.example.demo.entities.Sex;
import com.example.demo.entities.Situation;
import com.example.demo.entities.TypeAttestation;

@Projection(name = "inlinePartieCitoyen", types = { Attestation.class })
public interface AttestationProjection {

	Integer getId();
	
	
	Citoyen getCitoyen();
	TypeAttestation getTypeAttestation();
	AgentAutorite getAgentAutorite();
	String getBut();
	Date getCreatedAt();
	
	
	
}
