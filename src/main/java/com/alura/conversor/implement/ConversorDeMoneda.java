package com.alura.conversor.implement;

import java.math.BigDecimal;

import com.alura.conversor.interfaces.Conversor;
import com.alura.conversor.util.Moneda;

public class ConversorDeMoneda implements Conversor {

	public BigDecimal obtenerConversion(BigDecimal valor) {
		return Moneda.getInstance().multiplicar(valor, new BigDecimal("0.14"));
	}
	
	@Override
	public String toString() { 
		return "Conversor de Moneda";
	}

}
