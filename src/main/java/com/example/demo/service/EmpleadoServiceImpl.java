package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Empleado;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.IEmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	private IEmpleadoRepository empleadoRepository;

	@Override
	public void agregar(Empleado empleado) {
		this.empleadoRepository.insertar(empleado);
	}

	@Override
	public void modificar(Empleado empleado) {
		this.empleadoRepository.actualizar(empleado);
	}

	@Override
	public Empleado encontrar(Integer id) {
		return this.empleadoRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.empleadoRepository.eliminar(id);
	}
	
		

}
