package com.capas.uca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capas.uca.domain.Estudiante;
import com.capas.uca.domain.Pais;

public interface PaisRepository extends JpaRepository<Pais, Integer> 
{
	
	Pais findByid(int id);
}