package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "alumno")
@Entity
public class Alumno {
	
	@Id
	@SequenceGenerator(name = "seq_alum", sequenceName = "seq_alum",allocationSize = 1)
	@GeneratedValue(generator = "seq_alum",strategy = GenerationType.SEQUENCE)
	@Column(name = "alum_id")
	private Integer id;
	
	@Column(name = "alum_nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "alumno")
	private List<Matricula> matriculas;
	
	//SET Y GET
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

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	

}
