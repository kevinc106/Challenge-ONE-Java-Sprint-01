package com.alura.conversor.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.regex.Pattern;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame.JDesktopIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.alura.conversor.controller.ConversionesController;
import com.alura.conversor.interfaces.Conversor;

public class FormularioValorFrame extends JFrame{
	 
	private static final long serialVersionUID = 1L;
	private Conversor conversor;
	private ConversionesController conversionesController;
	private JLabel labelIngresaCantidad;
	private JTextField inputValor;
	private JButton botonConvertir;
	private JButton botonCancel;
	private JLabel labelIcono;

	public FormularioValorFrame(MenuFrame menuFrame, ConversionesController conversionesController) {
		 
		super("Input");
		this.conversionesController = conversionesController;
		
		Container container = getContentPane();
        setLayout(null);
        
        configurarCamposDelFormulario(container);

        configurarContenedor(container); 

        configurarAccionesDelFormulario();
	}

	private void configurarAccionesDelFormulario() {
		botonConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             	convertir();
            }
        });
    	botonCancel.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				dispose();
			} 
    	});
	}

	protected void convertir() {  
		String valor = inputValor.getText();
		if (valor.isBlank() || 
				!valor.trim().matches("[+]?\\d+(\\.\\d+)?([Ee][+]?\\d+)?")) {
			JOptionPane.showMessageDialog(this, "Valor no valido");
			return;
        }else{
        	System.out.println(new BigDecimal(valor.trim()));
        	this.conversionesController.setValor(new BigDecimal(valor.trim()));
        	//conversor.setValor(new BigDecimal(valor.trim()));
    		setVisible(false);
    		new SeleccionarConversionFrame(this,conversionesController);
        } 
	}

	private void configurarCamposDelFormulario(Container container) {
		
		labelIcono = new JLabel("(?)");
		 
		labelIcono.setBounds(20, 20, 20, 20);
		
		labelIngresaCantidad = new JLabel("Ingresa el valor que deseas convertir :"); 
		labelIngresaCantidad.setBounds(50, 5, 270, 20);
		labelIngresaCantidad.setForeground(Color.BLACK);
		
		inputValor = new JTextField(); 
		inputValor.setBounds(50, 25, 330, 25); 
		
		botonConvertir = new JButton("OK");
        botonConvertir.setBounds(100,55,80,25);
        
        botonCancel = new JButton("Cancel");
        botonCancel.setBounds(210,55,80,25); 
        
        container.add(labelIcono);
        container.add(labelIngresaCantidad);
        container.add(inputValor);
        container.add(botonConvertir);
        container.add(botonCancel); 
	}

	private void configurarContenedor(Container container) {
		setSize(400, 130);
        setVisible(true);  
        setLocationRelativeTo(null);
	}
	
}
