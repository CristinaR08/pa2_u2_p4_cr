package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="consultorio")
@Entity
public class ConsultorioMedico {

	@Id
	@SequenceGenerator(name = "seq_consultorio",sequenceName = "seq_consultorio",allocationSize = 1)//AllocantionSize tiene que ver con el valor de incremento que se puso en la base de datos
	@GeneratedValue(generator = "seq_consultorio",strategy = GenerationType.SEQUENCE)
	@Column(name= "cslt_id")
	private Integer id;
	@Column(name= "cslt_historia")
	private Integer historiaMedica;
	@Column(name= "cslt_valorPagado")
	private BigDecimal valorPagado;
	@Column(name= "cslt_fecha")
	private LocalDateTime fechaConsulta;
	@Column(name= "cslt_nombrePaciente")
	private String nombrePaciente;
	@Column(name= "cslt_apellidoPaciente")
	private String apellidoPaciente;
	@Column(name= "cslt_edadPaciente")
	private Integer edadPaciente;
	@Column(name= "cslt_especialidad")
	private String especialidad;
	@Column(name= "cslt_nombreDoctor")
	private String nombreDoctor;
	@Column(name= "cslt_apellidoDoctor")
	private String apellidoDoctor;
	
	//getters&setters
	
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "ConsultorioMedico [id=" + id + ", historiaMedica=" + historiaMedica + ", valorPagado=" + valorPagado
				+ ", fechaConsulta=" + fechaConsulta + ", nombrePaciente=" + nombrePaciente + ", apellidoPaciente="
				+ apellidoPaciente + ", edadPaciente=" + edadPaciente + ", especialidad=" + especialidad
				+ ", nombreDoctor=" + nombreDoctor + ", apellidoDoctor=" + apellidoDoctor + "]";
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHistoriaMedica() {
		return historiaMedica;
	}
	public void setHistoriaMedica(Integer historiaMedica) {
		this.historiaMedica = historiaMedica;
	}
	public BigDecimal getValorPagado() {
		return valorPagado;
	}
	public void setValorPagado(BigDecimal valorPagado) {
		this.valorPagado = valorPagado;
	}
	public LocalDateTime getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(LocalDateTime fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	public String getApellidoPaciente() {
		return apellidoPaciente;
	}
	public void setApellidoPaciente(String apellidoPaciente) {
		this.apellidoPaciente = apellidoPaciente;
	}
	public Integer getEdadPaciente() {
		return edadPaciente;
	}
	public void setEdadPaciente(Integer edadPaciente) {
		this.edadPaciente = edadPaciente;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getNombreDoctor() {
		return nombreDoctor;
	}
	public void setNombreDoctor(String nombreDoctor) {
		this.nombreDoctor = nombreDoctor;
	}
	public String getApellidoDoctor() {
		return apellidoDoctor;
	}
	public void setApellidoDoctor(String apellidoDoctor) {
		this.apellidoDoctor = apellidoDoctor;
	}
	
	
}
