package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	
	@Override
	public void matricular(Matricula matricula) {
		this.iMatriculaRepository.insertar(matricula);
	
	}
	@Override
	public void modificar(Matricula matricula) {
		this.iMatriculaRepository.actualizar(matricula);
	}
	@Override
	public Matricula encontrar(Integer id) {
		return this.iMatriculaRepository.buscar(id);
	}
	@Override
	public void borrar(Integer id) {
		this.iMatriculaRepository.eliminar(id);
	}
	@Override
	public List<MatriculaDTO> reporteAlumnoNomYMateriaNom() {
		return this.iMatriculaRepository.buscarTodas();
	}
}
