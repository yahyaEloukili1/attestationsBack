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
import com.example.demo.projections.AnnexeProjection;
import com.example.demo.projections.EndroitProjection;

@CrossOrigin(origins = "*")
public interface QuartierRepository extends JpaRepository<Quartier, Integer> {
	

	List<Quartier> findByDesignationContainsIgnoreCase(@Param("designation") String designation);
}
