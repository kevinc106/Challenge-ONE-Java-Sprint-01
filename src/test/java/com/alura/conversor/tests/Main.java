package com.alura.conversor.tests;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.alura.conversor.implement.ConversorADolar;
import com.alura.conversor.implement.ConversorAEuro;
import com.alura.conversor.implement.ConversorALibras;
import com.alura.conversor.implement.ConversorAWon;
import com.alura.conversor.implement.ConversorAYen;
import com.alura.conversor.interfaces.Conversor;

public class Main {

	public static void main(String[] args) {
		List<Conversor> conversores = new ArrayList<Conversor>();
		Conversor conversorADolar = new ConversorADolar();
		Conversor conversorAEuro = new ConversorAEuro();
		Conversor conversorALibras = new ConversorALibras();
		Conversor conversorAYen = new ConversorAYen();
		Conversor conversorAWon = new ConversorAWon();
		conversores.add(conversorADolar);
		conversores.add(conversorAEuro);
		conversores.add(conversorALibras);
		conversores.add(conversorAYen);
		conversores.add(conversorAWon);
		
		for (Conversor conversor : conversores) {
			System.out.println(conversor.convertir(new BigDecimal("1")));
		}
	}

}
