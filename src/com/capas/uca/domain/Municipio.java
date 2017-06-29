package com.capas.uca.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public" ,name = "municipio")
public class Municipio {
	@Id
	@GeneratedValue(generator="municipio_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "municipio_id_seq", sequenceName = "public.municipio_id_seq")
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
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "departamento")
	private Departamento departamento;
	
	@OneToMany(mappedBy = "municipio", fetch= FetchType.EAGER)
	private List<Estudiante> estudiantes;
	
	@OneToMany(mappedBy = "municipio", fetch= FetchType.EAGER)
	private List<Centro_escolar> centro_escolar;

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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public List<Centro_escolar> getCentro_escolar() {
		return centro_escolar;
	}

	public void setCentro_escolar(List<Centro_escolar> centro_escolar) {
		this.centro_escolar = centro_escolar;
	}
	
	

}
