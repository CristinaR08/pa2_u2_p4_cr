package com.example.demo.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name= "matricula")
public class Matricula {
	
	@Id
	@SequenceGenerator(name = "seq_matri", sequenceName = "seq_matri",allocationSize = 1)
	@GeneratedValue(generator = "seq_matri",strategy = GenerationType.SEQUENCE)
	@Column(name = "matri_id")
	private Integer id;
	
	@Column(name = "matri_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "matri_numero")
	private String numero;

	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "matricula_id_alumno")
	private Alumno alumno;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "matricula_id_materia")
	private Materia materia;
	
	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	
	

}
