package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Annexe;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.District;
import com.example.demo.entities.Endroit;
import com.example.demo.entities.Quartier;
import com.example.demo.entities.Rue;
import com.example.demo.projections.AnnexeProjection;
import com.example.demo.projections.DistrictProjection;
import com.example.demo.projections.EndroitProjection;
import com.example.demo.projections.RueProjection;

@CrossOrigin(origins = "*")
@RepositoryRestResource(excerptProjection = RueProjection.class)
public interface RueRepository extends JpaRepository<Rue, Integer> {

	
	  @Query("select a from Rue a where a.quartier.id = :quartierId")
	    List<Rue> findRuesByQuartierId(@Param("quartierId") Integer quartierId);
	  
	  @Query("select a from Rue a where a.quartier.id = :quartierId")
	    Page<Rue> findRuesByQuartierId2(@Param("quartierId") Integer quartierId,Pageable pageable);
}
