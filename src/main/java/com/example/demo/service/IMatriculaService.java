package com.example.demo.service;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaService {
	public void agregar(Matricula matricula);
	public void actualizar(Matricula matricula);
	public Matricula encontrar(Integer id);
	public void borrar(Integer id);
}
