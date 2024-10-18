package com.example.demo.dao;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.AppUser;
import com.example.demo.entities.Citoyen;
import com.example.demo.projections.AppUserProjection;
import com.example.demo.projections.CitoyenProjection;






@CrossOrigin(origins = "*")
@RepositoryRestResource(excerptProjection = CitoyenProjection.class)
public interface CitoyenRepository extends JpaRepository<Citoyen, Integer> {
	 @Query("SELECT e FROM Citoyen e WHERE e.cin = :cin")
	 List<Citoyen> findByCin2(@Param("cin") String cin);

	 List<Citoyen> findByPhone(String phone);
	 
	 List<Citoyen> findByEmail(String email);
	  @Query("SELECT e FROM Citoyen e " +
		       "WHERE (:pachalikId IS NULL OR e.pachalik.id = :pachalikId) " +
		       "AND (:districtId IS NULL OR e.district.id = :districtId) " +
		       "AND (:annexeId IS NULL OR e.annexe.id = :annexeId)"+
		       "AND (:quartierId IS NULL OR e.quartier.id = :quartierId)"+
		       "AND (:rueId IS NULL OR e.rue.id = :rueId)"+
		       "AND (:ruelleId IS NULL OR e.ruelle.id = :ruelleId)"+
		       "AND (:sexId IS NULL OR e.sex.id = :sexId) " +                // Added condition for sex
			  "AND (:situationId IS NULL OR e.situation.id = :situationId)") 
		Page<Citoyen> findByPachalikIdAndDistrictIdAndAnnexeIdAndQuartierIdAndRueIdAndRuelleIdAndSexIdAndSituationId(
		    
		        @Param("pachalikId") Integer pachalikId,
		        @Param("districtId") Integer districtId,
		        @Param("annexeId") Integer annexeId,
		        @Param("quartierId") Integer quartierId,
		        @Param("rueId") Integer rueId,
		        @Param("ruelleId") Integer ruelleId,
		        @Param("sexId") Integer sexId,                          
		        @Param("situationId") Integer situationId, 
		        Pageable pageable
		);
	  @Query("SELECT e FROM Citoyen e " +
		       "WHERE (:pachalikId IS NULL OR e.pachalik.id = :pachalikId) " +
		       "AND (:districtId IS NULL OR e.district.id = :districtId) " +
		       "AND (:annexeId IS NULL OR e.annexe.id = :annexeId)"+
		       "AND (:quartierId IS NULL OR e.quartier.id = :quartierId)"+
		       "AND (:rueId IS NULL OR e.rue.id = :rueId)"+
		       "AND (:ruelleId IS NULL OR e.ruelle.id = :ruelleId)"+
		       "AND (:sexId IS NULL OR e.sex.id = :sexId) " +                // Added condition for sex
			  "AND (:situationId IS NULL OR e.situation.id = :situationId)") 
		List<Citoyen> findByPachalikIdAndDistrictIdAndAnnexeIdAndQuartierIdAndRueIdAndRuelleIdAndSexIdAndSituationId2(
		       
		        @Param("pachalikId") Integer pachalikId,
		        @Param("districtId") Integer districtId,
		        @Param("annexeId") Integer annexeId,
		        @Param("quartierId") Integer quartierId,
		        @Param("rueId") Integer rueId,
		        @Param("ruelleId") Integer ruelleId,
		        @Param("sexId") Integer sexId,                          
		        @Param("situationId") Integer situationId
		);
}
