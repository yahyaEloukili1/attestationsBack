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

import com.example.demo.entities.Annexe;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.Citoyen;
import com.example.demo.entities.Endroit;
import com.example.demo.projections.AppUserProjection;
import com.example.demo.projections.EndroitProjection;







@CrossOrigin(origins = "*")
@RepositoryRestResource(excerptProjection = AppUserProjection.class)
public interface UserRepository extends JpaRepository<AppUser, Integer> {
	
	 Page<AppUser> findByCin(String cin, Pageable pageable);
	 
	 @Query("SELECT e FROM AppUser e WHERE e.cin = :cin")
	 List<AppUser> findByCin2(@Param("cin") String cin);

	  @Query("select a from AppUser a where a.role.id = :appRoleId")
	    Page<AppUser> findAppUsersByRoleId(@Param("appRoleId") Integer appRoleId, Pageable pageable);
	  
	  @Query("select a from AppUser a where a.annexe.id = :annexeId")
	    Page<AppUser> findAppUsersByAnnexeId(@Param("annexeId") Integer annexeId, Pageable pageable);
	  
	  @Query("SELECT e FROM AppUser e " +
		       "WHERE (:annexeId IS NULL OR e.annexe.id = :annexeId) " +
		       "AND (:roleId IS NULL OR e.role.id = :roleId)")
		Page<AppUser> findByAnnexeIdAndAppRoleId(
		        @Param("annexeId") Integer annexeId, 
		        @Param("roleId") Integer roleId, Pageable pageable
		);


	  @Query("SELECT e FROM AppUser e " +
		       "WHERE (:annexeId IS NULL OR e.annexe.id = :annexeId) " +
		       "AND (:roleId IS NULL OR e.role.id = :roleId)")
		List<AppUser> findByAnnexeIdAndAppRoleId2(
		        @Param("annexeId") Integer annexeId, 
		        @Param("roleId") Integer roleId
		);
	
	  @Query("SELECT e FROM AppUser e " +
		       "WHERE (:roleId IS NULL OR e.role.id = :roleId) " +
		       "AND (:pachalikId IS NULL OR e.pachalik.id = :pachalikId) " +
		       "AND (:districtId IS NULL OR e.district.id = :districtId) " +
		       "AND (:annexeId IS NULL OR e.annexe.id = :annexeId)")
		Page<AppUser> findByAppRoleIdAndPachalikIdAndDistrictIdAndAnnexeId(
		        @Param("roleId") Integer roleId,
		        @Param("pachalikId") Integer pachalikId,
		        @Param("districtId") Integer districtId,
		        @Param("annexeId") Integer annexeId,
		        Pageable pageable
		);
	  @Query("SELECT e FROM AppUser e " +
		       "WHERE (:roleId IS NULL OR e.role.id = :roleId) " +
		       "AND (:pachalikId IS NULL OR e.pachalik.id = :pachalikId) " +
		       "AND (:districtId IS NULL OR e.district.id = :districtId) " +
		       "AND (:annexeId IS NULL OR e.annexe.id = :annexeId)")
		List<AppUser> findByAppRoleIdAndPachalikIdAndDistrictIdAndAnnexeId2(
		        @Param("roleId") Integer roleId,
		        @Param("pachalikId") Integer pachalikId,
		        @Param("districtId") Integer districtId,
		        @Param("annexeId") Integer annexeId
		        
		);
		 @Query("SELECT e FROM AppUser e WHERE e.username = :username")
	 List<AppUser> findByUsername(String username);
	 List<AppUser> findByEmail(String email);
	 List<AppUser> findByPhone(String phone);
	 
	AppUser findAppUsersByUsername(String username);
	 boolean existsByCin(String cin);


	  
	 
}
