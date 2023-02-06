package com.alura.conversor.implement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.alura.conversor.interfaces.Conversor;
import com.alura.conversor.model.Conversion;

public class ConversorDeMoneda implements Conversor {
     
	List<Conversion> conversionDeMonedas; 
	
	public ConversorDeMoneda() { 
		if(conversionDeMonedas == null) {
			this.conversionDeMonedas= new ArrayList<Conversion>(); 
		}
	}
	
	@Override
	public String toString() { 
		return "Conversor de Moneda";
	} 

	@Override
	public String obtenerTitulo() {
		return "Monedas";
	}

	@Override
	public String obtenerDescripcion() {
		return "Elije la moneda a la que deseas convertir tu dinero";
	}

	@Override
	public List<Conversion> obtenerTiposDeConversiones() { 
		return this.conversionDeMonedas;
	}

	@Override
	public void addTiposDeConversion(List<Conversion> conversionDeMonedas) {
		this.conversionDeMonedas=conversionDeMonedas;
	} 

}
