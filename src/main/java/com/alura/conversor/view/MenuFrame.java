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

    //private JLabel labelNombre, labelDescripcion, labelCantidad, labelCategoria;
    //private JTextField textoNombre, textoDescripcion, textoCantidad;
    private JComboBox<Object> comboOpcionConversion;

	private JLabel labelOpcionConversion;

	private ConversionesController conversionesController;

	private JButton botonElegirConversion;

	private JButton botonCancel;
    /*private JButton botonGuardar, botonModificar, botonLimpiar, botonEliminar, botonReporte;
    private JTable tabla;
    private DefaultTableModel modelo;
    private ProductoController productoController;
    private CategoriaController categoriaController;*/

    public MenuFrame() {
        super("Menu");

        //this.categoriaController = new CategoriaController();
        this.conversionesController = new ConversionesController();

        Container container = getContentPane();
        setLayout(null);

        configurarCamposDelMenu(container);

        configurarTablaDeContenido(container);

        configurarAccionesDelFormulario();
    }

    private void configurarTablaDeContenido(Container container) {
        /*tabla = new JTable();

        modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("Identificador del Producto");
        modelo.addColumn("Nombre del Producto");
        modelo.addColumn("Descripción del Producto");
        modelo.addColumn("Cantidad del Producto");*/

       /*cargarTabla();

        tabla.setBounds(10, 205, 760, 280);

        botonEliminar = new JButton("Eliminar");
        botonModificar = new JButton("Modificar");
        botonReporte = new JButton("Ver Reporte");
        botonEliminar.setBounds(10, 500, 80, 20);
        botonModificar.setBounds(100, 500, 80, 20);
        botonReporte.setBounds(190, 500, 80, 20);
*/
        /*container.add(tabla);
        container.add(botonEliminar);
        container.add(botonModificar);
        container.add(botonReporte);*/

        setSize(300, 130);
        setVisible(true);  
        setLocationRelativeTo(null);
        
    }

    private void configurarCamposDelMenu(Container container) {
        /*labelNombre = new JLabel("Nombre del Producto");
        labelDescripcion = new JLabel("Descripción del Producto");
        labelCantidad = new JLabel("Cantidad");
        labelCategoria = new JLabel("Categoría del Producto");

        labelNombre.setBounds(10, 10, 240, 15);
        labelDescripcion.setBounds(10, 50, 240, 15);
        labelCantidad.setBounds(10, 90, 240, 15);
        labelCategoria.setBounds(10, 130, 240, 15);

        labelNombre.setForeground(Color.BLACK);
        labelDescripcion.setForeground(Color.BLACK);
        labelCategoria.setForeground(Color.BLACK);

        textoNombre = new JTextField();
        textoDescripcion = new JTextField();
        textoCantidad = new JTextField();*/
    	labelOpcionConversion = new JLabel("Seleccione una opcion de conversion");
    	labelOpcionConversion.setBounds(10, 5, 270, 20);
    	labelOpcionConversion.setForeground(Color.BLACK);
    	
        comboOpcionConversion = new JComboBox<Object>();
        comboOpcionConversion.setBounds(10, 25, 270, 25); 
        List<Conversor> conversiones = this.conversionesController.obtenerConversiones();
        conversiones.forEach(conversor -> comboOpcionConversion.addItem(conversor));
        
       
        botonElegirConversion = new JButton("OK");
        botonElegirConversion.setBounds(55,55,80,25);
        botonCancel = new JButton("Cancel");
        botonCancel.setBounds(145,55,80,25); 
        container.add(labelOpcionConversion);
        container.add(comboOpcionConversion);
        container.add(botonElegirConversion);
        container.add(botonCancel); 
    }

    private void configurarAccionesDelFormulario() {
    	botonElegirConversion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                elegir(); 
            }
        });
        /*botonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardar();
                limpiarTabla();
                cargarTabla();
            }
        });

        botonLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminar();
                limpiarTabla();
                cargarTabla();
            }
        });

        botonModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificar();
                limpiarTabla();
                cargarTabla();
            }
        });

        botonReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirReporte();
            }
        });*/
    }

    protected void elegir() {
    	Conversor conversor = (Conversor) comboOpcionConversion.getSelectedItem(); 
		System.out.println(conversor);
		new FormularioValorFrame(this,conversor);
	}

	private void abrirReporte() {
        //new ReporteFrame(this);
    }

    private void limpiarTabla() {
        //modelo.getDataVector().clear();
    }

    private boolean tieneFilaElegida() {
        return true;
    	//return tabla.getSelectedRowCount() == 0 || tabla.getSelectedColumnCount() == 0;
    }

    private void modificar() {
       /* if (tieneFilaElegida()) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }

        Optional.ofNullable(modelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()))
                .ifPresentOrElse(fila -> { 
                    Producto producto = new Producto(
                    		Integer.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 0).toString()),
                    		(String) modelo.getValueAt(tabla.getSelectedRow(), 1),
                    		(String) modelo.getValueAt(tabla.getSelectedRow(), 2),
                    		Integer.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 3).toString()));
                    
					this.productoController.modificar(producto);
					 
                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));*/
    }

    private void eliminar() {
        /*if (tieneFilaElegida()) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }

        Optional.ofNullable(modelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    Integer id = Integer.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());
 
					this.productoController.eliminar(id);
					 
                    modelo.removeRow(tabla.getSelectedRow());

                    JOptionPane.showMessageDialog(this, "Item eliminado con éxito!");
                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));*/
    }

    private void cargarTabla() {  
		/*var productos = this.productoController.listar(); 
	       
        productos.forEach(producto -> modelo.addRow(new Object[] {
        		producto.getId(), 
        		producto.getNombre(),
        		producto.getDescripcion(),
        		producto.getCantidad()
        		}));*/ 
	     
    }

    private void guardar() {
        /*if (textoNombre.getText().isBlank() || textoDescripcion.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Los campos Nombre y Descripción son requeridos.");
            return;
        }

        Integer cantidadInt;

        try {
            cantidadInt = Integer.parseInt(textoCantidad.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, String
                    .format("El campo cantidad debe ser numérico dentro del rango %d y %d.", 0, Integer.MAX_VALUE));
            return;
        }

       
        var categoria = (Categoria) comboOpcionConversion.getSelectedItem(); 
        var producto = new Producto(textoNombre.getText(),textoDescripcion.getText(),cantidadInt,categoria.getId());
         
        this.productoController.guardar(producto); 

        JOptionPane.showMessageDialog(this, "Registrado con éxito!");

        this.limpiarFormulario();*/
    }

    private void limpiarFormulario() {
        //this.textoNombre.setText("");
        //this.textoDescripcion.setText("");
        //this.textoCantidad.setText("");
        this.comboOpcionConversion.setSelectedIndex(0);
    }

}
