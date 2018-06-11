package com.capas.uca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capas.uca.domain.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> 
{
	
	Estudiante findByid(int id);
	List<Estudiante> findByEdad(int ano);
	List<Estudiante> findByNombreIgnoreCaseContaining(String nombre);
	List<Estudiante> findByApellidoIgnoreCaseContaining(String apellido);
	
	@Query("Select e from Estudiante e, Departamento d where e.departamento = d.id and d.descripcion like CONCAT('%',:departamento,'%')")
	List<Estudiante> encontrarPorDepartamento(@Param("departamento") String departamento);
	
	@Query("Select e from Estudiante e, Municipio d where e.municipio = d.id and d.descripcion like CONCAT('%',:municipio,'%')")
	List<Estudiante> encontrarPorMunicipio(@Param("municipio") String municipio);
}