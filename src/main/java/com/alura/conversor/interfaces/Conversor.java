package com.alura.conversor.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.alura.conversor.model.Conversion;

public interface Conversor {   
	
	public String obtenerTitulo();
	
	public String obtenerDescripcion();

	public List<Conversion> obtenerTiposDeConversiones();

	public void addTiposDeConversion(List<Conversion> conversionDeMonedas);
 
}
