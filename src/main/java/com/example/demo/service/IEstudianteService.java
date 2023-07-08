package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.dto.EstudianteDTO;

public interface IEstudianteService {
	
	public void agregar(Estudiante estudiante);
	public void modificar(Estudiante estudiante);
	public Estudiante encontrar(String cedula);
	public void borrar(String cedula);
	public Estudiante encontrarPorApellido(String apellido);
	public Estudiante encontrarPorApellidoTyped(String apellido);
	public List<Estudiante> encontrarListaPorApellido(String apellido);
	public Estudiante encontrarPorApellidoyNombre(String apellido, String nombre);
	public Estudiante encontrarPorApellidoNamedQuery(String apellido);
	public Estudiante encontrarPorApellidoNativeQuery(String apellido);
	public Estudiante encontrarPorApellidoNativeQueryNamed(String apellido); //debemos especificar el
	public Estudiante encontrarPorNombreNamedQuery(String nombre);
	public Estudiante encontrarPorNombreNativeQueryNamed(String nombre);
	public Estudiante encontrarEstudianteDinamico(String nombre, String apellido, Double peso);
	public int borrarPorNombre(String nombre);
	public int actualizarPorApellido(String nombre, String apellido);
	public List<EstudianteDTO> encontrarTodosDTO();

}
