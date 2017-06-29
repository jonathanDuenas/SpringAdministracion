package com.capas.uca.repository;


import java.util.Date;
import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capas.uca.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> 
{
	/*List<Usuario> findBySnombreStartingWithIgnoreCase(String nombre);
	List<Usuario> findBySapellidoContainingIgnoreCase(String apellido);
	List<Usuario> findByFingresoBetween(Date fi,Date fs);
	List<Usuario> findByFvencimientoAfter(Date fv);*/
	Usuario findByid(int id);
}
