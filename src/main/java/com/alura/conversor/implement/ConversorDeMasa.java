package com.alura.conversor.implement;

import java.util.ArrayList;
import java.util.List;

import com.alura.conversor.interfaces.Conversor;
import com.alura.conversor.model.Conversion;

public class ConversorDeMasa implements Conversor {

	List<Conversion> conversionDeMasa; 
	
	public ConversorDeMasa() { 
		if(conversionDeMasa == null) {
			this.conversionDeMasa= new ArrayList<Conversion>(); 
		}
	}
	
	@Override
	public String toString() { 
		return "Conversor de Masa";
	} 

	@Override
	public String obtenerTitulo() {
		return "Masa";
	}

	@Override
	public String obtenerDescripcion() {
		return "Elije la unidad a la que deseas convertir";
	}

	@Override
	public List<Conversion> obtenerTiposDeConversiones() { 
		return this.conversionDeMasa;
	}

	@Override
	public void addTiposDeConversion(List<Conversion> conversionDeMasa) {
		this.conversionDeMasa=conversionDeMasa;
	} 

}
