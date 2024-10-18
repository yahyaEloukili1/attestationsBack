package com.example.demo.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.District;
import com.example.demo.entities.Pachalik;
@CrossOrigin(origins = "*")
public interface PachalikRepository extends JpaRepository<Pachalik, Integer> {

	
	@RestResource(path= "/byPachalikPage")
	public Page<Pachalik> findByDesignationContainsIgnoreCase(@Param("mc") String pr,Pageable peaPageable);

	public Pachalik findByDesignationFr(String d);
	
	
}
