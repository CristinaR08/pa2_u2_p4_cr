package com.example.demo.repository;

import com.example.demo.repository.modelo.Empleado;

public interface IEmpleadoRepository {
	
	public void insertar(Empleado empleado);
	public void actualizar(Empleado empleado);
	public Empleado buscar(Integer id);
	public void eliminar(Integer id);

}
