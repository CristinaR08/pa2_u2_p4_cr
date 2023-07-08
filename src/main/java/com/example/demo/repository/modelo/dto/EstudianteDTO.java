package com.example.demo.repository.modelo.dto;

public class EstudianteDTO {
//creamos un dto exclusivo con los atributos que vayamos a utilizar
	
	private String nombre;
	private String apellido;
	
	public EstudianteDTO() {
		//constructor por defecto cuando no tengo argumentos
		
	}
	
	public EstudianteDTO(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	//toString
	@Override
	public String toString() {
		return "\nEstudianteDTO [nombre=" + nombre + ", apellido=" + apellido + "]";
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
	
	
	
}
