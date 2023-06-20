package com.example.demo.repository.modelo;

import org.hibernate.annotations.CollectionId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "estudiante")
@Entity //cuando mapeo una tabla con un objeto pasa a ser una ENTIDAD
public class Estudiante {
	
	@Id
	@SequenceGenerator(name = "seq_estudiante_generador",sequenceName = "seq_estudiante",allocationSize = 1)//AllocantionSize tiene que ver con el valor de incremento que se puso en la base de datos
	@GeneratedValue(generator = "seq_estudiante_generador",strategy = GenerationType.SEQUENCE)
	@Column(name= "estu_id")
	private Integer id;
	
	@Column(name = "estu_cedula")
	private String cedula;
	
	@Column(name = "estu_nombre")
	private String nombre;
	
	@Column(name = "estu_apellido")
	private String apellido;
	

	
	
	
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	//SET y GET
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
