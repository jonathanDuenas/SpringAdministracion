package com.capas.uca.domain;

public class Expediente {
	private int id;
	private String nombre;
	private String apellido;
	private int aprobadas;
	private int reprobadas;
	private float promedio;
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
	public int getAprobadas() {
		return aprobadas;
	}
	public void setAprobadas(int aprobadas) {
		this.aprobadas = aprobadas;
	}
	public int getReprobadas() {
		return reprobadas;
	}
	public void setReprobadas(int reprobadas) {
		this.reprobadas = reprobadas;
	}
	public float getPromedio() {
		return promedio;
	}
	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}
}
