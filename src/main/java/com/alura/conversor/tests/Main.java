package com.alura.conversor.tests;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.alura.conversor.implement.ConversorDeMoneda;
import com.alura.conversor.implement.ConversorDeTiempo; 
import com.alura.conversor.interfaces.Conversor;

public class Main {

	public static void main(String[] args) {
		List<Conversor> conversores = new ArrayList<Conversor>();
		Conversor conversorDeMoneda = new ConversorDeMoneda();
		Conversor conversorDeTiempo = new ConversorDeTiempo(); 
		conversores.add(conversorDeMoneda);
		conversores.add(conversorDeTiempo); 
		
		for (Conversor conversor : conversores) {
			System.out.println(conversor);
		}
	}

}
