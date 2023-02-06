import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.alura.conversor.controller.ConversionesController;
import com.alura.conversor.implement.ConversorDeMasa;
import com.alura.conversor.implement.ConversorDeMoneda;
import com.alura.conversor.implement.ConversorDeTemperatura;
import com.alura.conversor.implement.ConversorDeTiempo;
import com.alura.conversor.interfaces.Conversor;
import com.alura.conversor.model.Conversion;
import com.alura.conversor.model.ConversionTemperatura;
import com.alura.conversor.view.MenuFrame;

public class StartMain {

	public static void main(String[] args) { 
		ConversionesController conversionesController = new ConversionesController();
		Conversor conversorDeMoneda = new ConversorDeMoneda();
		Conversor conversorDeTiempo = new ConversorDeTiempo();
		Conversor conversorDeMasa = new ConversorDeMasa();
		Conversor conversorDeTemperatura = new ConversorDeTemperatura();
		
		List<Conversion> conversionDeMonedas = new ArrayList<Conversion>();
		conversionDeMonedas.add(new Conversion("Bolivianos","Dólar",new BigDecimal("0.14")));
		conversionDeMonedas.add(new Conversion("Bolivianos","Euro", new BigDecimal("0.13")));
		conversionDeMonedas.add(new Conversion("Bolivianos","Libras", new BigDecimal("0.12")));
		conversionDeMonedas.add(new Conversion("Bolivianos","Won",new BigDecimal("182.63")));
		conversionDeMonedas.add(new Conversion("Bolivianos","Yen",new BigDecimal("19.24")));
		conversionDeMonedas.add(new Conversion("Dólar","Bolivianos",new BigDecimal("6.91")));
		conversionDeMonedas.add(new Conversion("Euro","Bolivianos",new BigDecimal("7.52")));
		conversionDeMonedas.add(new Conversion("Libras","Bolivianos",new BigDecimal("8.31")));
		conversionDeMonedas.add(new Conversion("Won","Bolivianos",new BigDecimal("0.0055")));
		conversionDeMonedas.add(new Conversion("Yen","Bolivianos",new BigDecimal("0.053")));
		
		conversorDeMoneda.addTiposDeConversion(conversionDeMonedas);
		
		List<Conversion> conversionDeTiempo = new ArrayList<Conversion>();
		conversionDeTiempo.add(new Conversion("Día","Hora", new BigDecimal("24")));
		conversionDeTiempo.add(new Conversion("Hora","Minuto", new BigDecimal("60")));
		conversionDeTiempo.add(new Conversion("Minuto","Segundo", new BigDecimal("60")));
		conversionDeTiempo.add(new Conversion("Segundo","Milisegundo", new BigDecimal("1000")));
		conversionDeTiempo.add(new Conversion("Hora","Día",new BigDecimal("0.0416667")));
		conversionDeTiempo.add(new Conversion("Minuto","Hora",new BigDecimal("0.0166667")));
		conversionDeTiempo.add(new Conversion("Segundo","Minuto",new BigDecimal("0.0166667")));
		conversionDeTiempo.add(new Conversion("Milisegundo","Segundo",new BigDecimal("0.001")));
		
		conversorDeTiempo.addTiposDeConversion(conversionDeTiempo); 
		 
		List<Conversion> conversionDeMasa = new ArrayList<Conversion>();
		conversionDeMasa.add(new Conversion("Kg","g",new BigDecimal("1000")));
		conversionDeMasa.add(new Conversion("g","mg",new BigDecimal("1000")));
		conversionDeMasa.add(new Conversion("lb","g",new BigDecimal("453.592")));
		conversionDeMasa.add(new Conversion("oz","g",new BigDecimal("28.3495"))); 
		conversionDeMasa.add(new Conversion("g","Kg",new BigDecimal("0.001")));
		conversionDeMasa.add(new Conversion("mg","g",new BigDecimal("0.001")));
		conversionDeMasa.add(new Conversion("g","lb",new BigDecimal("0.00220462")));
		conversionDeMasa.add(new Conversion("g","oz",new BigDecimal("0.035274")));
		
		conversorDeMasa.addTiposDeConversion(conversionDeMasa);
		
		List<Conversion> conversionDeTemperatura = new ArrayList<Conversion>();
		conversionDeTemperatura.add(new ConversionTemperatura("CF","Grados Celsius","Grados Fahrenheit",new BigDecimal("33.8")));
		conversionDeTemperatura.add(new ConversionTemperatura("FC","Grados Fahrenheit","Grados Celsius",new BigDecimal("-17.2222")));
		conversionDeTemperatura.add(new ConversionTemperatura("KF","Grados Kelvin","Grados Fahrenheit",new BigDecimal("-457.87")));
		conversionDeTemperatura.add(new ConversionTemperatura("FK","Grados Fahrenheit","Grados Kelvin",new BigDecimal("255.928")));
		conversionDeTemperatura.add(new ConversionTemperatura("CK","Grados Celsius","Grados Kelvin",new BigDecimal("274.15")));
		conversionDeTemperatura.add(new ConversionTemperatura("KC","Grados Kelvin","Grados Celsius",new BigDecimal("-272.15")));
		
		conversorDeTemperatura.addTiposDeConversion(conversionDeTemperatura);
		
		conversionesController.addConversor(conversorDeMoneda);
		conversionesController.addConversor(conversorDeTiempo);
		conversionesController.addConversor(conversorDeMasa);
		conversionesController.addConversor(conversorDeTemperatura);
		
		MenuFrame menuFrame = new MenuFrame(conversionesController); 
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
