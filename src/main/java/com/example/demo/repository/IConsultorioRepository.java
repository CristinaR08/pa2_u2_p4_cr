package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.ConsultorioMedico;
import com.example.demo.repository.modelo.Estudiante;

public interface IConsultorioRepository {

	public void insertar(ConsultorioMedico consultorioMedico);
	public void actualizar(ConsultorioMedico consultorioMedico);
	public ConsultorioMedico buscarPorHistoriaMedica(Integer historiaMedica);
	public void eliminar(Integer historiaMedica);
	public ConsultorioMedico seleccionarPorFecha(LocalDateTime fecha);
	public List<ConsultorioMedico> seleccionarListaPorHistoriaTyped(Integer historiaMedica);
	public List<ConsultorioMedico> seleccionarDoctor(String apellido, String nombre);
	public ConsultorioMedico seleccionarPreciosTyped(BigDecimal pago);
	public ConsultorioMedico seleccionarDoctorDinamico(String apellidoPaciente, String nombrePaciente, LocalDateTime fechaConsulta, String especialidad);
	public int eliminarPorEdadPaciente(Integer edadP);
	public int actualizarPorHistoria(LocalDateTime fecha,Integer historiaMedica);
}
