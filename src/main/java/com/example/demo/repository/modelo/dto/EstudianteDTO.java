package com.example.demo.repository.modelo.dto;

public class EstudianteDTO {
	
	private String nombre;
	private String apellido;
	private Double peso;
	
	public EstudianteDTO() {
		//constructor por defecto cuando no tengo argumentos
		
	}
	
	public EstudianteDTO(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public EstudianteDTO(String nombre, String apellido, Double peso) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.peso = peso;
	}
	
	
	@Override
	public String toString() {
		return "EstudianteDTO [nombre=" + nombre + ", apellido=" + apellido + ", peso=" + peso + "]";
	}
	
	
	//getters y setters
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

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	
}
