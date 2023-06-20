package com.example.demo.service;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteService {
	
	public void agregar(Estudiante estudiante);
	public void modificar(Estudiante estudiante);
	public Estudiante encontrar(String cedula);
	public void borrar(String cedula);

}
