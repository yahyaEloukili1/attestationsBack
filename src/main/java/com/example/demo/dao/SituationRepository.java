package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.District;
import com.example.demo.entities.Situation;
@CrossOrigin(origins = "*")
public interface SituationRepository extends JpaRepository<Situation, Integer> {

	

}
