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
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

	@Override
	public ConsultorioMedico seleccionarDoctorDinamico(String apellidoPaciente, String nombrePaciente, LocalDateTime fechaConsulta, String especialidad) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<ConsultorioMedico>myCriteriaQuery=myBuilder.createQuery(ConsultorioMedico.class);
		Root<ConsultorioMedico>miTablaFrom = myCriteriaQuery.from(ConsultorioMedico.class);
		//condiciones:
		//Todas las fechas a partir del 2023 e.nombrePaciente=? AND e.apellidoPaciente=? AND e.especialidad=?
		//Todas las fechas antes del 1/1/2023 e.nombrePaciente=? OR e.apellidoPaciente?=? OR e.especialidad=? 
		Predicate pApellidoP = myBuilder.equal(miTablaFrom.get("apellidoPaciente"), apellidoPaciente);
		Predicate pNombreP = myBuilder.equal(miTablaFrom.get("nombrePaciente"), nombrePaciente);
		Predicate pEspecialidad = myBuilder.equal(miTablaFrom.get("especialidad"), especialidad);
		Predicate predicateFinal = null;
		if(fechaConsulta.compareTo(LocalDateTime.of(2023, 01, 01, 00, 00))<=0) {
			predicateFinal = myBuilder.or(pApellidoP,pNombreP,pEspecialidad);
		}else {
			predicateFinal = myBuilder.and(pApellidoP,pNombreP,pEspecialidad);
		}
		myCriteriaQuery.select(miTablaFrom).where(predicateFinal);
		TypedQuery<ConsultorioMedico> myQueryFinal = this.entityManager.createQuery(myCriteriaQuery);
		return myQueryFinal.getSingleResult();
	}

	@Override
	public int eliminarPorEdadPaciente(Integer edadP) {
		Query myQuery = this.entityManager.createQuery("DELETE FROM ConsultorioMedico e WHERE e.edadPaciente = :datoEdadPaciente");
		myQuery.setParameter("datoEdadPaciente", edadP);
		return myQuery.executeUpdate();
	}

	@Override
	public int actualizarPorHistoria(LocalDateTime fecha, Integer historiaMedica) {
		Query myQuery = this.entityManager.createQuery("UPDATE ConsultorioMedico e SET e.fechaConsulta = :datoFecha "
				+ "WHERE e.historiaMedica = :datoHistoria");
		myQuery.setParameter("datoFecha", fecha);
		myQuery.setParameter("datoHistoria", historiaMedica);
		return myQuery.executeUpdate();
	}

}
