package com.example.demo.projections;

import org.aspectj.weaver.loadtime.Agent;
import org.springframework.data.rest.core.config.Projection;

import com.example.demo.entities.AgentAutorite;
import com.example.demo.entities.Annexe;
import com.example.demo.entities.District;
import com.example.demo.entities.Fonction;
import com.example.demo.entities.FonctionHommeAUtorite;
import com.example.demo.entities.HommeAutorite;
import com.example.demo.entities.Pachalik;
import com.example.demo.entities.Quartier;
import com.example.demo.entities.Rue;



@Projection(name = "inlinePartie5", types = { AgentAutorite.class })
public interface AgentAutoriteProjection {

	int getId();
	String getNom();
	String getPrenom();
	String getCin();
	Fonction getFonction();
	Annexe getAnnexe();
}
