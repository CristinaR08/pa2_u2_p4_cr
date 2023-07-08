package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.dto.EstudianteDTO;
import com.example.demo.repository.IEstudianteRepo;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	
	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Override
	public void agregar(Estudiante estudiante) {
	this.estudianteRepo.insertar(estudiante);
		
	}

	@Override
	public void modificar(Estudiante estudiante) {
	this.estudianteRepo.actualizar(estudiante);	
		
	}

	@Override
	public Estudiante encontrar(String cedula) {
		return this.estudianteRepo.buscar(cedula);
	}

	@Override
	public void borrar(String cedula) {
		this.estudianteRepo.eliminar(cedula);
		
	}

	@Override
	public Estudiante encontrarPorApellido(String apellido) {
		return this.estudianteRepo.seleccionarPorApellido(apellido);
	}

	@Override
	public List<Estudiante> encontrarListaPorApellido(String apellido) {
		return this.estudianteRepo.seleccionarListaApellido(apellido);
	}

	@Override
	public Estudiante encontrarPorApellidoyNombre(String apellido, String nombre) {
		return this.estudianteRepo.seleccionarPorApellidoyNombre(apellido, nombre);
	}

	@Override
	public Estudiante encontrarPorApellidoTyped(String apellido) {
		return this.estudianteRepo.seleccionarPorApellidoTyped(apellido);
	}

	@Override
	public Estudiante encontrarPorApellidoNamedQuery(String apellido) {
		return this.estudianteRepo.seleccionarPorApellidoNamedQuery(apellido);
	}

	@Override
	public Estudiante encontrarPorApellidoNativeQuery(String apellido) {
		return this.estudianteRepo.seleccionarPorApellidoNativeQuery(apellido);
	}

	@Override
	public Estudiante encontrarPorApellidoNativeQueryNamed(String apellido) {
		return this.estudianteRepo.seleccionarPorApellidoNativeQueryNamed(apellido);
	}

	@Override
	public Estudiante encontrarPorNombreNamedQuery(String nombre) {
		return this.estudianteRepo.seleccionarPorNombreNamedQuery(nombre);
	}

	@Override
	public Estudiante encontrarPorNombreNativeQueryNamed(String nombre) {
		return this.estudianteRepo.seleccionarPorNombreNativeQueryNamed(nombre);
	}

	@Override
	public Estudiante encontrarEstudianteDinamico(String nombre, String apellido, Double peso) {
		return this.estudianteRepo.seleccionarEstudianteDinamico(nombre, apellido, peso);
	}

	@Override
	public int borrarPorNombre(String nombre) {
		return this.estudianteRepo.eliminarPorNombre(nombre);
	}

	@Override
	public int actualizarPorApellido(String nombre, String apellido) {
		return this.estudianteRepo.actualizarPorApellido(nombre, apellido);
	}

	@Override
	public List<EstudianteDTO> encontrarTodosDTO() {
		return this.estudianteRepo.seleccionarTodosDTO();
	}

}
