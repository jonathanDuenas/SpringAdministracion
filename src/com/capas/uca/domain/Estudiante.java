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
@Table(schema="public" ,name = "estudiante")
public class Estudiante {
	@Id
	@GeneratedValue(generator="estudiante_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "estudiante_id_seq", sequenceName = "public.estudiante_id_seq")
	@Column(name="id")
	private int id; 
	
	@Column(name="nombre")
    private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="carnet")
	private String carnet;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="fecha_nac")
	private Calendar fecha_nac;
	
	@Column(name="edad")
	private int edad;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "pais")
	private Pais pais;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "departamento")
	private Departamento departamento;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "municipio")
	private Municipio municipio;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="telefono")
	private int telefono;
	
	@Column(name="celular")
	private int celular;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "centro_escolar")
	private Centro_escolar centro_escolar;
	
	@Column(name="grado_cursado")
	private int grado_cursado;
	
	@Column(name="nota_grado")
	private float nota_grado;
	
	@Column(name="nombre_padre")
	private String nombre_padre;
	
	@Column(name="nombre_madre")
	private String nombre_madre;
	
	@Column(name="nombre_responsable")
	private String nombre_responsable;
	
	@Column(name="estado")
	private int estado;
	
	@OneToMany(mappedBy = "estudiante", fetch= FetchType.EAGER)
	private List<Materia_cursada> materia_cursada;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public Centro_escolar getCentro_escolar() {
		return centro_escolar;
	}

	public void setCentro_escolar(Centro_escolar centro_escolar) {
		this.centro_escolar = centro_escolar;
	}

	public int getGrado_cursado() {
		return grado_cursado;
	}

	public void setGrado_cursado(int grado_cursado) {
		this.grado_cursado = grado_cursado;
	}

	public float getNota_grado() {
		return nota_grado;
	}

	public void setNota_grado(float nota_grado) {
		this.nota_grado = nota_grado;
	}

	public String getNombre_padre() {
		return nombre_padre;
	}

	public void setNombre_padre(String nombre_padre) {
		this.nombre_padre = nombre_padre;
	}

	public String getNombre_madre() {
		return nombre_madre;
	}

	public void setNombre_madre(String nombre_madre) {
		this.nombre_madre = nombre_madre;
	}

	public String getNombre_responsable() {
		return nombre_responsable;
	}

	public void setNombre_responsable(String nombre_responsable) {
		this.nombre_responsable = nombre_responsable;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<Materia_cursada> getMateria_cursada() {
		return materia_cursada;
	}

	public void setMateria_cursada(List<Materia_cursada> materia_cursada) {
		this.materia_cursada = materia_cursada;
	}
	
	
}
