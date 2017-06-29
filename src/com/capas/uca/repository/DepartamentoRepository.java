package com.capas.uca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capas.uca.domain.Departamento;
import com.capas.uca.domain.Estudiante;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> 
{
	
	Departamento findByid(int id);
}