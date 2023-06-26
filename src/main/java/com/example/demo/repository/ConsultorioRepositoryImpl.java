package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.ConsultorioMedico;
import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ConsultorioRepositoryImpl implements IConsultorioRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertar(ConsultorioMedico consultorioMedico) {
		this.entityManager.persist(consultorioMedico);
		
	}

	@Override
	public void actualizar(ConsultorioMedico consultorioMedico) {
		this.entityManager.merge(consultorioMedico);
		
	}

	@Override
	public ConsultorioMedico buscarPorHistoriaMedica(Integer historiaMedica) {
		return this.entityManager.find(ConsultorioMedico.class, historiaMedica);
	}

	@Override
	public void eliminar(Integer historiaMedica) {
		ConsultorioMedico consu = this.buscarPorHistoriaMedica(historiaMedica);
		this.entityManager.remove(consu);
		
	}

	@Override
	public ConsultorioMedico seleccionarPorFecha(LocalDateTime fecha) {
		Query myQuery = this.entityManager.createQuery("SELECT e FROM ConsultorioMedico e WHERE e.fechaConsulta = :datoFecha");
		myQuery.setParameter("datoFecha", fecha);
		return (ConsultorioMedico) myQuery.getSingleResult();
	}

	@Override
	public List<ConsultorioMedico> seleccionarDoctor(String apellido, String nombre) {
		Query myQuery = this.entityManager.createQuery("SELECT e FROM ConsultorioMedico e WHERE e.apellidoDoctor = :datoApellido AND e.nombreDoctor = :datoNombre");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public ConsultorioMedico seleccionarPreciosTyped(BigDecimal pago) {
		TypedQuery<ConsultorioMedico> myQuery = this.entityManager.createQuery("SELECT e FROM ConsultorioMedico e WHERE e.valorPagado = :datoValor", ConsultorioMedico.class);
		myQuery.setParameter("datoValor", pago);
		return myQuery.getSingleResult();
	}

	@Override
	public List<ConsultorioMedico> seleccionarListaPorHistoriaTyped(Integer historiaMedica) {
		TypedQuery<ConsultorioMedico> myQuery = this.entityManager.createQuery("SELECT e FROM ConsultorioMedico e WHERE e.historiaMedica = :datoHistoria", ConsultorioMedico.class);
		myQuery.setParameter("datoHistoria",historiaMedica);
		return myQuery.getResultList();
	}

}
