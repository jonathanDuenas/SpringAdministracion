package com.capas.uca.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public" ,name = "materia")
public class Materia {
	@Id
	@GeneratedValue(generator="materia_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "materia_id_seq", sequenceName = "public.materia_id_seq")
	@Column(name="id")
	private Integer id; 
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="estado")
	private int estado;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="fecha_creacion")
	private Calendar fecha_creacion;
	
	@Column(name="usuario_creacion")
	private int usuario_creacion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="fecha_modificacion")
	private Calendar fecha_modificacion;
	
	@Column(name="usuario_modificacion")
	private int usuario_modificacion;
	
	@OneToMany(mappedBy = "materia", fetch= FetchType.EAGER)
	private List<Materia_cursada> materia_cursadas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Calendar getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Calendar fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public int getUsuario_creacion() {
		return usuario_creacion;
	}

	public void setUsuario_creacion(int usuario_creacion) {
		this.usuario_creacion = usuario_creacion;
	}

	public Calendar getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Calendar fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public int getUsuario_modificacion() {
		return usuario_modificacion;
	}

	public void setUsuario_modificacion(int usuario_modificacion) {
		this.usuario_modificacion = usuario_modificacion;
	}

	public List<Materia_cursada> getMateria_cursadas() {
		return materia_cursadas;
	}

	public void setMateria_cursadas(List<Materia_cursada> materia_cursadas) {
		this.materia_cursadas = materia_cursadas;
	}
	
	
}
