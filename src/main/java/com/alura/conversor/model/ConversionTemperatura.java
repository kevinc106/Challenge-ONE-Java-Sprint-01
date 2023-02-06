package com.alura.conversor.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.alura.conversor.util.OperatorMath;
import com.alura.conversor.util.OperatorTemperature;

public class ConversionTemperatura extends Conversion{

	private String shorName;

	public ConversionTemperatura(String shorName,String nombreMonedaBase, String nombreMonedaConvertida, BigDecimal toValue) {
		super(nombreMonedaBase, nombreMonedaConvertida, toValue);
		this.shorName=shorName;
	}
	
	@Override
	public BigDecimal obtenConversion(BigDecimal valor) {  
		switch (shorName) {
		case "CF":
			return new BigDecimal(OperatorTemperature.getInstance().C_F(valor.doubleValue())).setScale(2, RoundingMode.CEILING);  
		case "CK":
			return new BigDecimal(OperatorTemperature.getInstance().C_K(valor.doubleValue())).setScale(2, RoundingMode.CEILING); 
		case "FK":
			return new BigDecimal(OperatorTemperature.getInstance().F_K(valor.doubleValue())).setScale(2, RoundingMode.CEILING); 
		case "FC":
			return new BigDecimal(OperatorTemperature.getInstance().F_C(valor.doubleValue())).setScale(2, RoundingMode.CEILING); 
		case "KF":
			return new BigDecimal(OperatorTemperature.getInstance().K_F(valor.doubleValue())).setScale(2, RoundingMode.CEILING); 
		case "KC":
			return new BigDecimal(OperatorTemperature.getInstance().K_C(valor.doubleValue())).setScale(2, RoundingMode.CEILING);	  
		}
		return new BigDecimal(0);
	} 

}
