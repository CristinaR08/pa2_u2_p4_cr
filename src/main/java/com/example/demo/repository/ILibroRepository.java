package com.example.demo.repository;

import com.example.demo.repository.modelo.Libro;

public interface ILibroRepository {

	public void insertar(Libro libro);
	public void modificar(Libro libro);
	public Libro buscar(Integer id);
	public void eliminar(Integer id);
}
