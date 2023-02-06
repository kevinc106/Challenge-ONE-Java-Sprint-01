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
			/*this.conversionDeTiempo.add(new Conversion("Dia","Hora",
						new BigDecimal("24"),new BigDecimal("0.0416667")));
			this.conversionDeTiempo.add(new Conversion("Hora","Minuto",
						new BigDecimal("60"),new BigDecimal("0.0166667")));
			this.conversionDeTiempo.add(new Conversion("Minuto","Segundo",
						new BigDecimal("60"),new BigDecimal("0.0166667")));
			this.conversionDeTiempo.add(new Conversion("Segundo","Milisegundo",
						new BigDecimal("1000"),new BigDecimal("0.001"))); */
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
