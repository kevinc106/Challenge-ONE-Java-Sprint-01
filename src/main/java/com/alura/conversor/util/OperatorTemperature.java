package com.alura.conversor.util;
 

public class OperatorTemperature { 
	
	private static OperatorTemperature operatorTemperature; 
	
	public static OperatorTemperature getInstance() {
		if(operatorTemperature==null) {
			operatorTemperature = new OperatorTemperature();
		}
		return operatorTemperature; 
	}

	  //Celcius to Fahrenheit
	  public Double C_F(Double C){
	    Double F = (C * 9/5) + 32;
	    return F;
	  }
	  //Celcius to Kelvin
	  public Double C_K(Double C){
	    Double K = C + 273.15;
	    return K;
	  }
	  
	  //Fahrenheit to Celcius
	  public Double F_C(Double F){
	    Double C = (F - 32) * 5/9;
	    return C;
	  }
	  //Fahrenheit to Kelvin
	  public Double F_K(Double F){
	    Double K = (F - 32) * 5/9 + 273.15;
	    return K;
	  }
	  
	  //Kelvin to Celcius
	  public Double K_C(Double K){
	    Double C = K - 273.15;
	    return C;
	  }
	  //Kelvin to Fahrenheit
	  public Double K_F(Double K){
	    Double F = (K - 273.15) * 9/5 + 32;
	    return F;
	  } 
}
