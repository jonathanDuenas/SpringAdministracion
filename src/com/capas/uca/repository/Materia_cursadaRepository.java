package com.capas.uca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capas.uca.domain.Estudiante;
import com.capas.uca.domain.Materia_cursada;

public interface Materia_cursadaRepository extends JpaRepository<Materia_cursada, Integer> 
{
	
	Materia_cursada findByid(int id);
}