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
import com.example.demo.entities.Endroit;
import com.example.demo.entities.Quartier;
import com.example.demo.entities.Rue;
import com.example.demo.entities.Ruelle;
import com.example.demo.projections.AnnexeProjection;
import com.example.demo.projections.EndroitProjection;
import com.example.demo.projections.RueProjection;
import com.example.demo.projections.RuelleProjection;

@CrossOrigin(origins = "*")
@RepositoryRestResource(excerptProjection = RuelleProjection.class)
public interface RuelleRepository extends JpaRepository<Ruelle, Integer> {

	
	  @Query("select a from Ruelle a where a.rue.id = :rueId")
	    Page<Ruelle> findRuellesByRueId2(@Param("rueId") Integer rueId, Pageable pageable);
	  @Query("select a from Ruelle a where a.rue.id = :rueId")
	    List<Ruelle> findRuellesByRueId(@Param("rueId") Integer rueId);
}
