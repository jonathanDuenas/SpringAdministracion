package com.capas.uca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capas.uca.domain.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> 
{
	
	Estudiante findByid(int id);
}