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
import com.example.demo.entities.Attestation;
import com.example.demo.entities.Citoyen;
import com.example.demo.projections.AppUserProjection;
import com.example.demo.projections.AttestationProjection;
import com.example.demo.projections.CitoyenProjection;






@CrossOrigin(origins = "*")
@RepositoryRestResource(excerptProjection = AttestationProjection.class)
public interface AttestationRepository extends JpaRepository<Attestation, Integer> {
	 @Query("SELECT e FROM Attestation e WHERE e.cin = :cin")
	 List<Attestation> findByCin2(@Param("cin") String cin);


	 @Query("SELECT e FROM Attestation e " +
		       "JOIN e.citoyen c " +
		       "WHERE (:cin IS NULL OR c.cin = :cin) " +
		       "AND (:typeAttestation IS NULL OR e.typeAttestation = :typeAttestation)")
		Page<Attestation> findByCinAndTypeAttestation(
		        @Param("cin") String cin,
		        @Param("typeAttestation") String typeAttestation,
		        Pageable pageable
		);

	 @Query("SELECT e FROM Attestation e " +
		       "WHERE (:cin IS NULL OR e.cin = :cin) " +
		       "AND (:typeAttestation IS NULL OR e.typeAttestation = :typeAttestation)")
		List<Attestation> findByCinAndTypeAttestation2(
		        @Param("cin") String cin,
		        @Param("typeAttestation") String typeAttestation
		);

}
