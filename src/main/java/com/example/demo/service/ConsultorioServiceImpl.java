package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IConsultorioRepository;
import com.example.demo.repository.modelo.ConsultorioMedico;

@Service
public class ConsultorioServiceImpl implements IConsultorioService{

	@Autowired
	private IConsultorioRepository consultorioRepository;
	
	@Override
	public void agregar(ConsultorioMedico consultorioMedico) {
		this.consultorioRepository.insertar(consultorioMedico);
		
	}

	@Override
	public void modificar(ConsultorioMedico consultorioMedico) {
		this.consultorioRepository.actualizar(consultorioMedico);
		
	}

	@Override
	public ConsultorioMedico encontrar(Integer historiaMedica) {
		return this.consultorioRepository.buscarPorHistoriaMedica(historiaMedica);
	}

	@Override
	public void borrar(Integer historiaMedica) {
		this.consultorioRepository.eliminar(historiaMedica);
		
	}

	@Override
	public ConsultorioMedico encontrarPorFecha(LocalDateTime fecha) {
		return this.consultorioRepository.seleccionarPorFecha(fecha);
	}

	@Override
	public List<ConsultorioMedico> encontrarDoctor(String apellido, String nombre) {
		return this.consultorioRepository.seleccionarDoctor(apellido, nombre);
	}

	@Override
	public ConsultorioMedico encontrarPreciosTyped(BigDecimal pago) {
		return this.consultorioRepository.seleccionarPreciosTyped(pago);
	}

	@Override
	public List<ConsultorioMedico> encontrarListaPorHistoriaTyped(Integer historia) {
		return this.consultorioRepository.seleccionarListaPorHistoriaTyped(historia);
	}

	@Override
	public ConsultorioMedico encontrarDoctorDinamico(String apellidoPaciente, String nombrePaciente,
			LocalDateTime fechaConsulta, String especialidad) {
		return this.consultorioRepository.seleccionarDoctorDinamico(apellidoPaciente, nombrePaciente, fechaConsulta, especialidad);
	}

	@Override
	public int actualizarPorHistoria(LocalDateTime fecha, Integer historiaMedica) {
		return this.consultorioRepository.actualizarPorHistoria(fecha, historiaMedica);
	}

	@Override
	public int borrarPorEdadPaciente(Integer edadP) {
		return this.consultorioRepository.eliminarPorEdadPaciente(edadP);
	}


}
