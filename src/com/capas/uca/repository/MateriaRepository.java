package com.capas.uca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capas.uca.domain.Estudiante;
import com.capas.uca.domain.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Integer> 
{
	
	Materia findByid(int id);
}