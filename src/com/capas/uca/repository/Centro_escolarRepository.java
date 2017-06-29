package com.capas.uca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capas.uca.domain.Centro_escolar;
import com.capas.uca.domain.Estudiante;

public interface Centro_escolarRepository extends JpaRepository<Centro_escolar, Integer> 
{
	
	Centro_escolar findByid(int id);
}