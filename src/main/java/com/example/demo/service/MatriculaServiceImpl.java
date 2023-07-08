package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import jakarta.transaction.Transactional;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepository matriculaRepository;
	
	@Override
	public void agregar(Matricula matricula) {
		this.matriculaRepository.insertar(matricula);
		
	}

	@Override
	public void actualizar(Matricula matricula) {
		this.matriculaRepository.modificar(matricula);
		
	}

	@Override
	public Matricula encontrar(Integer id) {
		return this.matriculaRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.matriculaRepository.eliminar(id);
		
	}

	@Override
	public List<MatriculaDTO> encontrarTodosDTO() {
		return this.matriculaRepository.seleccionarTodosDTO();
	}

}
