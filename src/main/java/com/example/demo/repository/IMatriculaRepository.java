package com.example.demo.repository;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaRepository {

	public void insertar(Matricula matricula);
	public void modificar(Matricula matricula);
	public Matricula buscar(Integer id);
	public void eliminar(Integer id);
}
