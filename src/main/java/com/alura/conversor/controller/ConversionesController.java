package com.alura.conversor.controller;
 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.alura.conversor.implement.ConversorDeMoneda;
import com.alura.conversor.implement.ConversorDeTiempo;
import com.alura.conversor.interfaces.Conversor;
import com.alura.conversor.model.Conversion;

public class ConversionesController {
	 
	private Conversion conversionSeleccionada;
	private BigDecimal valor;
	private List<Conversor> conversores;
	private int indiceConversorSeleccionado = -1;
	
	public ConversionesController() {
		if(this.conversores==null) {
			this.conversores = new ArrayList<>(); 
		}
	}
	
	public void addConversor(Conversor con) {
		this.conversores.add(con);
	}
 
	public List<Conversor> obtenerTiposDeConversores() { 
		return conversores;
	}
	
	public void setConversion(Conversion conversionSeleccionada) {
		this.conversionSeleccionada=conversionSeleccionada;
	} 
		
	public BigDecimal obtenerConversion() { 
		return this.conversionSeleccionada.obtenConversion(this.valor);
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getIndiceConversorSeleccionado() {
		return indiceConversorSeleccionado;
	}
	
	public Conversion getConversion() {
		return this.conversionSeleccionada;
	}

	public void setIndiceConversorSeleccionado(int indiceConversorSeleccionado) {
		this.indiceConversorSeleccionado = indiceConversorSeleccionado;
	}

	public String obtenerTituloConversor() { 
		return this.conversores.get(this.indiceConversorSeleccionado).obtenerTitulo(); 
	}

	public String obtenerDescripcionConversor() {
		return this.conversores.get(this.indiceConversorSeleccionado).obtenerDescripcion(); 
	}

	public List<Conversion> obtenerTiposDeConversionesConversor() {
		return this.conversores.get(this.indiceConversorSeleccionado).obtenerTiposDeConversiones();
	}

	public BigDecimal getValor() {
		return this.valor;
	}

}
