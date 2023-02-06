package com.alura.conversor.view;

import java.awt.Container;
import java.awt.Color;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.alura.conversor.controller.ConversionesController;
import com.alura.conversor.interfaces.Conversor;
import com.alura.conversor.model.Conversion;

public class SeleccionarConversionFrame extends JFrame{

	private ConversionesController conversionesController;
	private JLabel labelDescrpicion;
	private JComboBox<Object> comboOpcionConversion;
	private JButton botonConvertir;
	private JButton botonCancel;

	public SeleccionarConversionFrame(ConversionesController conversionesController) {
		 
		super(conversionesController.obtenerTituloConversor());
		this.conversionesController = conversionesController;
		
		Container container = getContentPane();
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        configurarCamposDelFormulario(container);

        configurarContenedor(container); 

        configurarAccionesDelFormulario();
	}

	private void configurarAccionesDelFormulario() { 
		botonConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
        		elegirConversion();
             	realizarConversion();
             	preguntarContinuar();
            }
        });
		botonCancel.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				dispose();
			} 
    	}); 
	}

	private void elegirConversion() {
		Conversion ConversionElegida = (Conversion) comboOpcionConversion.getSelectedItem(); 
		//System.out.println(ConversionElegida);
		this.conversionesController.setConversion(ConversionElegida);
	}

	private void realizarConversion() { 
		BigDecimal resultado = this.conversionesController.obtenerConversion(true);
		//System.out.println("Resultado "+ resultado);
		mostrarResultado(resultado); 
	}

	private void mostrarResultado(BigDecimal resultado) {
		String mensaje = String.format("%s %s son %s %s", 
				this.conversionesController.getValor(),
				this.conversionesController.getConversion().getNombreBase(),
				resultado,
				this.conversionesController.getConversion().getNombreConvertido());
		setVisible(false);
		JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	 
	} 
	
	private void preguntarContinuar() {
		int respuesta = JOptionPane.showConfirmDialog(this,"¿Desea continuar?","Seleccione una opción",JOptionPane.YES_NO_CANCEL_OPTION);
		accionarConfirmacion(respuesta);
	}

	private void accionarConfirmacion(int respuesta) { 
        switch (respuesta) {
        case 0:
        	new MenuFrame(this.conversionesController);
        	this.dispose();
            break;
        case 1:
        	JOptionPane.showMessageDialog(this, "Programa terminado", "Finalizando", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        	break;
        case 2:
        	JOptionPane.showMessageDialog(this, "Programa terminado", "Finalizando", JOptionPane.INFORMATION_MESSAGE);
        	this.dispose();
        	break;
        }
	}

	private void configurarContenedor(Container container) {
		setSize(335, 130);
        setVisible(true);  
        setLocationRelativeTo(null);
	}

	private void configurarCamposDelFormulario(Container container) { 
	 
		int width = this.conversionesController.obtenerDescripcionConversor().length(); 
		labelDescrpicion = new JLabel(this.conversionesController.obtenerDescripcionConversor()); 
		labelDescrpicion.setBounds(10, 5,width*100, 20);
		labelDescrpicion.setForeground(Color.BLACK);
		
		comboOpcionConversion = new JComboBox<Object>();
        comboOpcionConversion.setBounds(10, 25, 300, 25); 
        List<Conversion> conversiones = this.conversionesController.obtenerTiposDeConversionesConversor();
        conversiones.forEach(conversion -> comboOpcionConversion.addItem(conversion));
		 
		botonConvertir = new JButton("OK");
        botonConvertir.setBounds(70,55,80,25);
        
        botonCancel = new JButton("Cancel");
        botonCancel.setBounds(180,55,80,25); 
         
        container.add(labelDescrpicion);
        container.add(comboOpcionConversion);
        container.add(botonConvertir);
        container.add(botonCancel); 
	}

}
