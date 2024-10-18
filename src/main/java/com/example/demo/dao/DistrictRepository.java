package com.example.demo.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Annexe;
import com.example.demo.entities.District;
import com.example.demo.projections.AnnexeProjection;
import com.example.demo.projections.DistrictProjection;
import com.example.demo.projections.EndroitProjection;
@CrossOrigin(origins = "*")
@RepositoryRestResource(excerptProjection = DistrictProjection.class)
public interface DistrictRepository extends JpaRepository<District, Integer> {

	
	@RestResource(path= "/byDistrictPage")
	public Page<District> findByDesignationContainsIgnoreCase(@Param("mc") String pr,Pageable peaPageable);
	@Query("select a from District a where a.pachalik.id = :pachalikId")
    List<District> findDistrictsByPachalikId(@Param("pachalikId") Integer pachalikId);
}
