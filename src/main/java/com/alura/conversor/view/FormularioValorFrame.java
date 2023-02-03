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

import com.alura.conversor.interfaces.Conversor;

public class FormularioValorFrame extends JFrame{
	 
	private static final long serialVersionUID = 1L;
	private Conversor conversor;
	private JLabel labelIngresaCantidad;
	private JTextField inputValor;
	private JButton botonConvertir;
	private JButton botonCancel;
	private JLabel labelIcono;

	public FormularioValorFrame(MenuFrame menuFrame, Conversor conversor) {
		 
		super("Input");
		this.conversor = conversor;
		
		Container container = getContentPane();
        setLayout(null);
        
        configurarCamposDelFormulario(container);

        configurarTablaDeContenido(container); 

        configurarAccionesDelFormulario();
	}

	private void configurarAccionesDelFormulario() {
		botonConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             	convertir();
            }
        });
	}

	protected void convertir() {  
		if (inputValor.getText().isBlank() || 
				!inputValor.getText().trim().matches("[+]?\\d+(\\.\\d+)?([Ee][+]?\\d+)?")) {
			JOptionPane.showMessageDialog(this, "Valor no valido");
			return;
        }else{
        	System.out.println("entra");            
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

	private void configurarTablaDeContenido(Container container) {
		setSize(400, 130);
        setVisible(true);  
        setLocationRelativeTo(null);
	}
	
}
