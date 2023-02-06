package com.alura.conversor.view;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.alura.conversor.controller.ConversionesController;
import com.alura.conversor.interfaces.Conversor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class MenuFrame  extends JFrame {

    private static final long serialVersionUID = 1L;
 
    private JComboBox<Object> comboTipoConversion;

	private JLabel labelOpcionConversion;

	private ConversionesController conversionesController;

	private JButton botonElegirConversion, botonCancel; 

    public MenuFrame() {
        super("Menu");
 
        this.conversionesController = new ConversionesController();

        Container container = getContentPane();
        setLayout(null);

        configurarCamposDelMenu(container);

        configurarTablaDeContenido(container);

        configurarAccionesDelFormulario();
    }

    private void configurarTablaDeContenido(Container container) { 
        setSize(300, 130);
        setVisible(true);  
        setLocationRelativeTo(null);
        
    }

    private void configurarCamposDelMenu(Container container) { 
    	labelOpcionConversion = new JLabel("Seleccione una opcion de conversion");
    	labelOpcionConversion.setBounds(10, 5, 270, 20);
    	labelOpcionConversion.setForeground(Color.BLACK);
    	
        comboTipoConversion = new JComboBox<Object>();
        comboTipoConversion.setBounds(10, 25, 270, 25); 
        List<Conversor> conversiones = this.conversionesController.obtenerTiposDeConversores();
        conversiones.forEach(conversor -> comboTipoConversion.addItem(conversor));
        
       
        botonElegirConversion = new JButton("OK");
        botonElegirConversion.setBounds(55,55,80,25);
        botonCancel = new JButton("Cancel");
        botonCancel.setBounds(145,55,80,25); 
        container.add(labelOpcionConversion);
        container.add(comboTipoConversion);
        container.add(botonElegirConversion);
        container.add(botonCancel); 
    }

    private void configurarAccionesDelFormulario() {
    	botonElegirConversion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                elegir(); 
            }
        });
    	botonCancel.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				dispose();
			} 
    	}); 
    }

    protected void elegir() {
    	Conversor conversorSelecionado = (Conversor) comboTipoConversion.getSelectedItem();
    	int indiceConversor = conversionesController.obtenerTiposDeConversores().indexOf(conversorSelecionado);
		conversionesController.setIndiceConversorSeleccionado(indiceConversor);
    	System.out.println(conversionesController.obtenerTiposDeConversores().indexOf(conversorSelecionado));
		new FormularioValorFrame(conversionesController); 
		this.dispose();
	} 

}
