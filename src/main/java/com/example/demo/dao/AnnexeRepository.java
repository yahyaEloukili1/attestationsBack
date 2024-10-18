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
import com.example.demo.projections.AnnexeProjection;
import com.example.demo.projections.EndroitProjection;

@CrossOrigin(origins = "*")
@RepositoryRestResource(excerptProjection = AnnexeProjection.class)
public interface AnnexeRepository extends JpaRepository<Annexe, Integer> {
	List<Annexe> findByDistrictId(Integer id);

	
	@RestResource(path= "/byAnnexePage")
	public Page<Annexe> findByDesignationContainsIgnoreCase(@Param("mc") String pr,Pageable peaPageable);
	
	  @Query("select a from Annexe a where a.district.id = :districtId")
	    List<Annexe> findAnnexesByDistrictId(@Param("districtId") Integer districtId);
}
