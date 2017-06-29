package com.capas.uca.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public" ,name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(generator="usuario_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "usuario_id_seq", sequenceName = "public.usuario_id_seq")
	@Column(name="id")
	private Integer id;
    
	@Column(name="nombre")
    private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="fecha_nac")
	private Calendar fecha_nac;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="estado")
	private int estado;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="password")
	private String password;
	
	@Column(name="tipo")
	private int tipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Calendar getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Calendar fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	

}
