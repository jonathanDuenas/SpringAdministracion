package com.capas.uca.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public" ,name = "materia_cursada")
public class Materia_cursada {
	@Id
	@GeneratedValue(generator="materia_cursada_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "materia_cursada_id_seq", sequenceName = "public.materia_cursada_id_seq")
	@Column(name="id")
	private Integer id;
    
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "materia")
    private Materia materia;
	
	@Column(name="ano")
	private int ano;
	
	@Column(name="periodo")
	private int periodo;
	
	@Column(name="nota")
	private float nota;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "estudiante")
	private Estudiante estudiante;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	
	
	
}
