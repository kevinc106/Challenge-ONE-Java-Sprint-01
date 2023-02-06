package com.alura.conversor.model;

import java.math.BigDecimal;

import com.alura.conversor.util.OperatorMath;

public class Conversion {
	
	private String nombreBase;
	private String nombreAConvertir;
	private BigDecimal toValue;
	private BigDecimal fromValue; 
	
	public Conversion(String nombreMonedaBase, String nombreMonedaConvertida, BigDecimal toValue,
			BigDecimal fromValue) { 
		this.nombreBase = nombreMonedaBase;
		this.nombreAConvertir = nombreMonedaConvertida;
		this.toValue = toValue;
		this.fromValue = fromValue;
	}

	@Override
	public String toString() {
		return String.format("De %s a %s", nombreBase, nombreAConvertir);
	}
	// 1  V -> toValue    2    V   -> fromValue
	public BigDecimal obtenConversion(BigDecimal valor, boolean invertido) {
		if(invertido) {			
			return OperatorMath.getInstance().multiplicar(valor, toValue);
		}
		return OperatorMath.getInstance().multiplicar(valor, fromValue);
	} 
	 
	public String getNombreBase() {
		return nombreBase;
	}

	public void setNombreBase(String nombreMonedaBase) {
		this.nombreBase = nombreMonedaBase;
	}

	public String getNombreConvertido() {
		return nombreAConvertir;
	}

	public void setNombreConvertido(String nombreMonedaConvertida) {
		this.nombreAConvertir = nombreMonedaConvertida;
	}

	public BigDecimal getToValue() {
		return toValue;
	}
	public void setToValue(BigDecimal toValue) {
		this.toValue = toValue;
	}
	public BigDecimal getFromValue() {
		return fromValue;
	}
	public void setFromValue(BigDecimal fromValue) {
		this.fromValue = fromValue;
	}
	
}
