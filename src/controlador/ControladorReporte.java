package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import modelo.ConsultarArticuloReporte;
import modelo.ConsultaClienteReporte;
import modelo.ConsultaGanancia;

import ventanas.VentanaReporte;
import ventanas.VentanaAbastecer;
import ventanas.VentanaGanancias;

public class ControladorReporte implements ActionListener {
	VentanaReporte ventanaReporte;
	//VentanaAbastecer ventanaAbastecer;
	
	ConsultaGanancia consultaGanancia = new ConsultaGanancia();
	ConsultarArticuloReporte consultarArticuloReporte = new ConsultarArticuloReporte();
	ConsultaClienteReporte consultaClienteReporte = new ConsultaClienteReporte();
	
		public ControladorReporte(VentanaReporte ventanaReporte) {
		this.ventanaReporte = ventanaReporte;
		this.ventanaReporte.btnVerVentas.addActionListener(this);
		this.ventanaReporte.btnVerInventario.addActionListener(this);
		this.ventanaReporte.btnVerDescuentos.addActionListener(this);
		//consultarArticuloReporte.llenarTabla(ventanaReporte.abastecer.table);
		this.ventanaReporte.descuentos.btnSelec.addActionListener(this);
		this.ventanaReporte.ganancias.btnSelec.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventanaReporte.btnVerVentas) {
			//Visibles
			ventanaReporte.ganancias.setVisible(true);
			ventanaReporte.abastecer.setVisible(false);
			ventanaReporte.descuentos.setVisible(false);
		}
		
		if(e.getSource() == ventanaReporte.ganancias.btnSelec) {
			int opcion = ventanaReporte.ganancias.comboBoxVentas.getSelectedIndex();
			java.util.Date fechita = (java.util.Date) ventanaReporte.ganancias.datePicker.getModel().getValue();
						
			reiniciarTabla (ventanaReporte.ganancias.table);
			
			JLabel totalGa = ventanaReporte.ganancias.lblTotalGanancia;
			
			if(opcion == 0 || fechita == null ) {
				JOptionPane.showMessageDialog(null, "Por favor seleccione una opción y fecha valida");
			} else {
				if(opcion == 1) {
					consultaGanancia.llenarTabla(ventanaReporte.ganancias.table, false, fechita, totalGa);
					} else if(opcion == 2) {
					consultaGanancia.llenarTabla(ventanaReporte.ganancias.table, true, fechita, totalGa);
					}
			}
		}
		
		
		if(e.getSource() == ventanaReporte.btnVerInventario) {
			//Visibles
			ventanaReporte.ganancias.setVisible(false);
			ventanaReporte.abastecer.setVisible(true);
			ventanaReporte.descuentos.setVisible(false);
			
			reiniciarTabla (ventanaReporte.abastecer.table);
			consultarArticuloReporte.llenarTabla(ventanaReporte.abastecer.table);
		}
		
		
		if(e.getSource() == ventanaReporte.btnVerDescuentos) {
			//Visibles
			ventanaReporte.ganancias.setVisible(false);
			ventanaReporte.abastecer.setVisible(false);
			ventanaReporte.descuentos.setVisible(true);
			
			reiniciarTabla (ventanaReporte.descuentos.table);
		}
		
		
		if(e.getSource() == ventanaReporte.descuentos.btnSelec) {
			
			int opcion = ventanaReporte.descuentos.comboBoxCumple.getSelectedIndex();
			
			reiniciarTabla (ventanaReporte.descuentos.table);
			
			if(opcion == 1) {
			consultaClienteReporte.llenarTabla(ventanaReporte.descuentos.table, true);
			} else if(opcion == 2) {
			consultaClienteReporte.llenarTabla(ventanaReporte.descuentos.table, false);
			} else {
				JOptionPane.showMessageDialog(null, "Por favor seleccione una opción para filtrar");
			}
		}
		
	}
	
	
	public void reiniciarTabla (JTable table) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
	}
	
	
	
	}
	