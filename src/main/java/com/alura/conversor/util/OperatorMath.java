package com.alura.conversor.util;

import java.math.BigDecimal;

public class OperatorMath {
	
	private static OperatorMath operatorMath; 

	public static OperatorMath getInstance() {
		if(operatorMath==null) {
			operatorMath = new OperatorMath();
		}
		return operatorMath; 
	}
	
	public BigDecimal multiplicar(BigDecimal big1,BigDecimal big2) {
		//BigDecimal big1 = new BigDecimal("0.1");
		//BigDecimal big2 = new BigDecimal("0.2"); 
		BigDecimal res = big1.multiply(big2); 
		return res;
	}
	
	public BigDecimal dividir(BigDecimal big1,BigDecimal big2) { 
		BigDecimal res = big1.divide(big2); 
		return res;
	}
	 
	
}
