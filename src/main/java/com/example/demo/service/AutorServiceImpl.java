package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IAutorRepository;
import com.example.demo.repository.modelo.Autor;

@Service
public class AutorServiceImpl implements IAutorService{

	@Autowired
	private IAutorRepository autorRepo;

	@Override
	public void agregar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRepo.insertar(autor);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRepo.modificar(autor);
	}

	@Override
	public Autor encontrar(Integer id) {
		// TODO Auto-generated method stub
		return this.autorRepo.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.autorRepo.eliminar(id);
	}
}
