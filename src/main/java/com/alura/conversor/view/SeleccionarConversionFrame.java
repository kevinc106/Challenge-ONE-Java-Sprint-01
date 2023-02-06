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

	public SeleccionarConversionFrame(FormularioValorFrame formularioValorFrame, ConversionesController conversionesController) {
		 
		super(conversionesController.obtenerTituloConversor());
		this.conversionesController = conversionesController;
		
		Container container = getContentPane();
        setLayout(null);
        
        configurarCamposDelFormulario(container);

        configurarContenedor(container); 

        configurarAccionesDelFormulario();
	}

	private void configurarAccionesDelFormulario() {
		/*comboOpcionConversion.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				elegirConversion();
			} 
		});*/
		botonConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             	realizarConversion();
            }
        });
	}

	protected void elegirConversion() {
		Conversion ConversionElegida = (Conversion) comboOpcionConversion.getSelectedItem(); 
		System.out.println(ConversionElegida);
		this.conversionesController.setConversion(ConversionElegida);
	}

	protected void realizarConversion() { 
		elegirConversion();
		BigDecimal val = this.conversionesController.obtenerConversion(true);
		System.out.println("Resultado "+ val);		 
		 
	}

	private void configurarContenedor(Container container) {
		setSize(300, 130);
        setVisible(true);  
        setLocationRelativeTo(null);
	}

	private void configurarCamposDelFormulario(Container container) { 
	 
		int width = this.conversionesController.obtenerDescripcionConversor().length(); 
		labelDescrpicion = new JLabel(this.conversionesController.obtenerDescripcionConversor()); 
		labelDescrpicion.setBounds(50, 5,270, 20);
		labelDescrpicion.setForeground(Color.BLACK);
		
		comboOpcionConversion = new JComboBox<Object>();
        comboOpcionConversion.setBounds(10, 25, 270, 25); 
        List<Conversion> conversiones = this.conversionesController.obtenerTiposDeConversionesConversor();
        conversiones.forEach(conversor -> comboOpcionConversion.addItem(conversor));
		 
		botonConvertir = new JButton("OK");
        botonConvertir.setBounds(100,55,80,25);
        
        botonCancel = new JButton("Cancel");
        botonCancel.setBounds(210,55,80,25); 
         
        container.add(labelDescrpicion);
        container.add(comboOpcionConversion);
        container.add(botonConvertir);
        container.add(botonCancel); 
	}

}
