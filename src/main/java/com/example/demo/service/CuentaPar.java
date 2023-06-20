package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service("par")
public class CuentaPar implements CalculoCuenta {

	@Override
	public BigDecimal valorMatricula(BigDecimal montoCuenta) {
		// TODO Auto-generated method stub
		BigDecimal valorPar= montoCuenta.multiply(new BigDecimal(0.05));
		return valorPar;
	}

}
