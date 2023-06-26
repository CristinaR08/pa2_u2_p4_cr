package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.ConsultorioMedico;

public interface IConsultorioRepository {

	public void insertar(ConsultorioMedico consultorioMedico);
	public void actualizar(ConsultorioMedico consultorioMedico);
	public ConsultorioMedico buscarPorHistoriaMedica(Integer historiaMedica);
	public void eliminar(Integer historiaMedica);
	public ConsultorioMedico seleccionarPorFecha(LocalDateTime fecha);
	public List<ConsultorioMedico> seleccionarListaPorHistoriaTyped(Integer historiaMedica);
	public List<ConsultorioMedico> seleccionarDoctor(String apellido, String nombre);
	public ConsultorioMedico seleccionarPreciosTyped(BigDecimal pago);
}
