package com.alura.conversor.implement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.alura.conversor.interfaces.Conversor;
import com.alura.conversor.model.Conversion; 

public class ConversorDeTiempo implements Conversor {
   
	private List<Conversion> conversionDeTiempo;
	
	public ConversorDeTiempo() {
		if(conversionDeTiempo == null) {
			this.conversionDeTiempo= new ArrayList<Conversion>(); 
		}
	}

	@Override
	public String toString() { 
		return "Conversor de Tiempo";
	} 

	@Override
	public String obtenerTitulo() {
		return "Tiempo";
	}

	@Override
	public String obtenerDescripcion() {
		return "Elije el tiempo al que deseas convertir tu valor";
	}

	@Override
	public List<Conversion> obtenerTiposDeConversiones() { 
		return conversionDeTiempo;
	}

	@Override
	public void addTiposDeConversion(List<Conversion> conversionDeTiempo) {
		this.conversionDeTiempo=conversionDeTiempo;
	}

 
}
