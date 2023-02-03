package com.alura.conversor.controller;

import java.util.ArrayList;
import java.util.List;

import com.alura.conversor.implement.ConversorDeMoneda;
import com.alura.conversor.implement.ConversorDeTiempo; 
import com.alura.conversor.interfaces.Conversor;

public class ConversionesController {
 
	public List<Conversor> obtenerConversiones() {
		List<Conversor> conversores = new ArrayList<>();
		Conversor conversorADolar = new ConversorDeMoneda();
		Conversor conversorAEuro = new ConversorDeTiempo(); 
		conversores.add(conversorADolar);
		conversores.add(conversorAEuro); 
		return conversores;
	}

}
