package com.alura.conversor.implement;

import java.math.BigDecimal;

import com.alura.conversor.interfaces.Conversor;
import com.alura.conversor.util.Moneda;

public class ConversorAWon implements Conversor {

	public BigDecimal convertir(BigDecimal valor) {
		return Moneda.getInstance().multiplicar(valor, new BigDecimal("180.27"));
	}

}