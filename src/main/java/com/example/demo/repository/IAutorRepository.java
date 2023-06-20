package com.example.demo.repository;

import com.example.demo.repository.modelo.Autor;

public interface IAutorRepository {

	public void insertar(Autor autor);
	public void modificar(Autor autor);
	public Autor buscar(Integer id);
	public void eliminar(Integer id);
}
