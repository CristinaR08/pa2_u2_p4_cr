package com.example.demo.repository1;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteRepository {
	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(String cedula);

	public Estudiante seleccionar(String cedula);
}
