package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.NamedQuery;

public interface IEstudianteRepo {
	
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante buscar(String cedula);
	public void eliminar(String cedula);
	public Estudiante seleccionarPorApellido(String apellido);
	public Estudiante seleccionarPorApellidoTyped(String apellido);
	public List<Estudiante> seleccionarListaApellido(String apellido);
	public Estudiante seleccionarPorApellidoyNombre(String apellido, String nombre);
	public Estudiante seleccionarPorApellidoNamed(String apellido);
	public Estudiante seleccionarPorApellidoNamedQuery(String apellido);
	public Estudiante seleccionarPorApellidoNativeQuery(String apellido);
	public Estudiante seleccionarPorApellidoNativeQueryNamed(String apellido);
	public Estudiante seleccionarPorNombreNamedQuery(String nombre);
	public Estudiante seleccionarPorNombreNativeQueryNamed(String nombre);
	public Estudiante seleccionarPorApellidoCriteriaAPIQuery(String apellido);

	
}
//@NamedQuery(name="Estudiante.buscarPorNombreNative",query="SELECT e FROM Estudiante e WHERE e.nombre = :datoNombre")
//