package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ILibroRepository;
import com.example.demo.repository.modelo.Libro;


@Service
public class LibroServiceImpl implements ILibroService{

	@Autowired
	private ILibroRepository iLibroRepo;

	@Override
	public void agregar(Libro libro) {
		this.iLibroRepo.insertar(libro);
	}

	@Override
	public void actualizar(Libro libro) {
		this.iLibroRepo.modificar(libro);
	}

	@Override
	public Libro encontrar(Integer id) {
		return this.iLibroRepo.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.iLibroRepo.eliminar(id);
	}
}
