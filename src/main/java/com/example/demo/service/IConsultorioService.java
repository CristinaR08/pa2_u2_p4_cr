package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.ConsultorioMedico;

public interface IConsultorioService {

	public void agregar(ConsultorioMedico consultorioMedico);
	public void modificar(ConsultorioMedico consultorioMedico);
	public ConsultorioMedico encontrar(Integer historiaMedica);
	public void borrar(Integer historiaMedica);
	public ConsultorioMedico encontrarPorFecha(LocalDateTime fecha);
	public List<ConsultorioMedico> encontrarListaPorHistoriaTyped(Integer historia);
	public ConsultorioMedico encontrarPreciosTyped(BigDecimal pago);
	public List<ConsultorioMedico> encontrarDoctor(String apellido, String nombre);
	public ConsultorioMedico encontrarDoctorDinamico(String apellidoPaciente, String nombrePaciente, LocalDateTime fechaConsulta, String especialidad);

}
