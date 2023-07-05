package com.example.demo.service;

import com.example.demo.repository.modelo.Autor;

public interface IAutorService {
	public void agregar(Autor autor);
	public void actualizar(Autor autor);
	public Autor encontrar(Integer id);
	public void borrar(Integer id);
}
