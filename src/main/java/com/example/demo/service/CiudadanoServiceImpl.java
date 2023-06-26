package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.repository.ICiudadanoRepository;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService{

	@Autowired
	private ICiudadanoRepository ciudadanoRepository;
	
	@Override
	public void agregar(Ciudadano ciudadano) {
		this.ciudadanoRepository.insertar(ciudadano);
	}

	@Override
	public void modificar(Ciudadano ciudadano) {
		this.ciudadanoRepository.actulizar(ciudadano);
	}

	@Override
	public Ciudadano encontrar(Integer id) {
		return this.ciudadanoRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.ciudadanoRepository.eliminar(id);
	}

}
