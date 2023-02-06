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
			this.conversionDeMonedas.add(new Conversion("Boliviano","Dolar",
						new BigDecimal("0.14"),new BigDecimal("6.97")));
			this.conversionDeMonedas.add(new Conversion("Boliviano","Euro",
						new BigDecimal("0.13"),new BigDecimal("7.52")));
			this.conversionDeMonedas.add(new Conversion("Boliviano","Libras",
						new BigDecimal("0.12"),new BigDecimal("8.40")));
			this.conversionDeMonedas.add(new Conversion("Boliviano","Won",
						new BigDecimal("178.94"),new BigDecimal("0.0056")));
			this.conversionDeMonedas.add(new Conversion("Boliviano","Yen",
						new BigDecimal("18.96"),new BigDecimal("0.053")));
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

}
