package com.capas.uca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capas.uca.domain.Estudiante;
import com.capas.uca.domain.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, Integer> 
{
	
	Municipio findByid(int id);
}