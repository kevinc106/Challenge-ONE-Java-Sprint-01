package com.alura.conversor.implement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.alura.conversor.interfaces.Conversor;
import com.alura.conversor.model.Conversion; 

public class ConversorDeTemperatura implements Conversor {
   
	private List<Conversion> conversionDeTemperatura;
	
	public ConversorDeTemperatura() {
		if(conversionDeTemperatura == null) {
			this.conversionDeTemperatura= new ArrayList<Conversion>(); 
		}
	}

	@Override
	public String toString() { 
		return "Conversor de Temperatura";
	} 

	@Override
	public String obtenerTitulo() {
		return "Temperatura";
	}

	@Override
	public String obtenerDescripcion() {
		return "Elije la temperatura al que deseas convertir tu valor";
	}

	@Override
	public List<Conversion> obtenerTiposDeConversiones() { 
		return conversionDeTemperatura;
	}

	@Override
	public void addTiposDeConversion(List<Conversion> conversionDeTemperatura) {
		this.conversionDeTemperatura=conversionDeTemperatura;
	}

 
}
