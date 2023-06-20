package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "cuenta_bancaria")
@Entity
public class CuentaBancaria {
	
	@Id
	@SequenceGenerator(name = "seq_cta_generador",sequenceName = "seq_cta",allocationSize = 1)//AllocantionSize tiene que ver con el valor de incremento que se puso en la base de datos
	@GeneratedValue(generator = "seq_cta_generador",strategy = GenerationType.SEQUENCE)
	@Column(name="cta_id")
	private Integer id;
	
	@Column(name="cta_numero")
	private String numero;
	
	@Column(name="cta_tipo")
	private String tipo;
	
	@Column(name="cta_fecha")
	private LocalDateTime fecha;
	
	@Column(name="cta_saldo")
	private BigDecimal saldo;
	
	@Column(name="cta_cedPropietario")
	private String cedulaPropietario;
	
	
	
	//SET y GET
	
	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", fecha=" + fecha + ", saldo="
				+ saldo + ", cedulaPropietario=" + cedulaPropietario + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public String getCedulaPropietario() {
		return cedulaPropietario;
	}
	public void setCedulaPropietario(String cedulaPropietario) {
		this.cedulaPropietario = cedulaPropietario;
	}
	
	

}
