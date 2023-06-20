package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.ICuentaRepository;

@Service
public class CuentaServiceImpl implements ICuentaService {

	@Autowired
	private ICuentaRepository cuentaRepository;
	/*@Override
	public void aperturarCuenta(String tipo, String numero, String cedulaP, BigDecimal saldo) {
		// TODO Auto-generated method stub
		CuentaBancaria cuenta = new CuentaBancaria();
		cuenta.setFecha(LocalDate.now());
		cuenta.setCedulaPropietario(cedulaP);
		cuenta.setSaldo(new BigDecimal(200));
		cuenta.setCedulaPropietario("123");
		cuenta.setTipo("ahorros");
		
		Integer dia= cuenta.getFecha().getDayOfYear();
		BigDecimal valor=null;
		if(dia %2 ==0) {
			valor=cuenta.getSaldo().multiply(new BigDecimal(0.05));
			System.out.println("Cuenta Beneficiada con 5% adicional");
		}else {
			System.out.println("Cuenta Creada");
		}
		
		
	}*/

	@Override
	public void aperturarCuenta(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.cuentaRepository.insertar(bancaria);
	}

	@Override
	public void modificarCuenta(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.cuentaRepository.actualizar(bancaria);
	}

	@Override
	public CuentaBancaria consultarSaldo(Integer id) {
		// TODO Auto-generated method stub
		return this.cuentaRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
			this.cuentaRepository.borrar(id);
	}

	@Override
	public void ingresarDeposito(Integer id, BigDecimal monto) {
		// TODO Auto-generated method stub
		BigDecimal regaloApertura= null;
		CuentaBancaria cuenta=this.consultarSaldo(id);
		BigDecimal saldoCuenta = cuenta.getSaldo();
		Integer dia= cuenta.getFecha().getDayOfMonth();
		
		if(dia %2==0) {
			BigDecimal montoRegalo= monto.multiply(new BigDecimal(0.05));
			regaloApertura=montoRegalo.add(monto);
			
			cuenta.setSaldo(saldoCuenta.add(montoRegalo));
			cuentaRepository.actualizar(cuenta);
			System.out.println("Cuenta con beneficio");
		}else {
			System.out.println("Cuenta Creada Bienvenido");
			cuenta.setSaldo(saldoCuenta.add(monto));
			cuentaRepository.actualizar(cuenta);
		}
	}


}
