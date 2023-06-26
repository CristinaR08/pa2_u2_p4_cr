package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepo {
	
	
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante buscar(String cedula);
	public void eliminar(String cedula);
	public Estudiante seleccionarPorApellido(String apellido);
	public Estudiante seleccionarPorApellidoTyped(String apellido);
	public List<Estudiante> seleccionarListaApellido(String apellido);
	public Estudiante seleccionarPorApellidoyNombre(String apellido, String nombre);

}
