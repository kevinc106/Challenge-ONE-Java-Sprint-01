import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.alura.conversor.controller.ConversionesController;
import com.alura.conversor.implement.ConversorDeMasa;
import com.alura.conversor.implement.ConversorDeMoneda;
import com.alura.conversor.implement.ConversorDeTiempo;
import com.alura.conversor.interfaces.Conversor;
import com.alura.conversor.model.Conversion;
import com.alura.conversor.view.MenuFrame;

public class StartMain {

	public static void main(String[] args) { 
		ConversionesController conversionesController = new ConversionesController();
		Conversor conversorDeMoneda = new ConversorDeMoneda();
		Conversor conversorDeTiempo = new ConversorDeTiempo();
		Conversor conversorDeMasa = new ConversorDeMasa();
		
		List<Conversion> conversionDeMonedas = new ArrayList<Conversion>();
		conversionDeMonedas.add(new Conversion("Boliviano","Dólar",new BigDecimal("0.14")));
		conversionDeMonedas.add(new Conversion("Boliviano","Euro", new BigDecimal("0.13")));
		conversionDeMonedas.add(new Conversion("Boliviano","Libras", new BigDecimal("0.12")));
		conversionDeMonedas.add(new Conversion("Boliviano","Won",new BigDecimal("182.63")));
		conversionDeMonedas.add(new Conversion("Boliviano","Yen",new BigDecimal("19.24")));
		conversionDeMonedas.add(new Conversion("Dólar","Boliviano",new BigDecimal("6.91")));
		conversionDeMonedas.add(new Conversion("Euro","Boliviano",new BigDecimal("7.52")));
		conversionDeMonedas.add(new Conversion("Libras","Boliviano",new BigDecimal("8.31")));
		conversionDeMonedas.add(new Conversion("Won","Boliviano",new BigDecimal("0.0055")));
		conversionDeMonedas.add(new Conversion("Yen","Boliviano",new BigDecimal("0.053")));
		
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
		
		conversionesController.addConversor(conversorDeMoneda);
		conversionesController.addConversor(conversorDeTiempo);
		conversionesController.addConversor(conversorDeMasa);
		
		MenuFrame menuFrame = new MenuFrame(conversionesController); 
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
