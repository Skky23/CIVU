package ventanas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

import java.awt.Font;
import java.util.Properties;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;


//
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdatepicker.impl.JDatePanelImpl;
//


import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.SwingConstants;


public class VentanaGanancias extends JPanel {
	public JButton btnSelec;
	public JComboBox comboBoxVentas;
	public JTable table;
	DefaultTableModel model;
	public JLabel lblTotalGanancia;
	public JDatePickerImpl datePicker;
	
	/**
	 * Create the panel.
	 */
	public VentanaGanancias() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		setSize(885, 485);
		setLocation(0, 0);
		
		//VENTAS
				JLabel lblSelectDiaMes = new JLabel("Ventas");
				lblSelectDiaMes.setFont(new Font("Roboto", Font.BOLD, 14));
				lblSelectDiaMes.setBounds(30, 143, 150, 17);
				add(lblSelectDiaMes);
				
				JSeparator separator_V = new JSeparator();
				separator_V.setForeground(new Color(0, 153, 255));
				separator_V.setBounds(30, 185, 150, 2);
				add(separator_V);
				
				comboBoxVentas = new JComboBox();
				comboBoxVentas.setBackground(Color.WHITE);
				comboBoxVentas.setFont(new Font("Roboto", Font.PLAIN, 14));
				comboBoxVentas.setModel(new DefaultComboBoxModel(new String[] {"", "Mensual", "Diario"}));
				comboBoxVentas.setBorder(null);
				comboBoxVentas.setBounds(30, 162, 150, 20);
				add(comboBoxVentas);
				
				//
				JLabel lblSelectFecha = new JLabel("Fecha");
				lblSelectFecha.setFont(new Font("Roboto", Font.BOLD, 14));
				lblSelectFecha.setBounds(200, 143, 150, 17);
				add(lblSelectFecha);
				
				JSeparator separator_F = new JSeparator();
				separator_F.setForeground(new Color(0, 153, 255));
				separator_F.setBounds(200, 185, 150, 2);
				add(separator_F);
				
					UtilDateModel modelPicker = new UtilDateModel();
					Properties p = new Properties();
					p.put("text.today", "Today");
					p.put("text.month", "Month");
					p.put("text.year", "Year");
					JDatePanelImpl datePanel = new JDatePanelImpl(modelPicker, p);
					
					datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
					datePicker.setBounds(200, 162, 150, 20);
					
					add(datePicker);
				//
					
					btnSelec = new JButton("SELECCIONAR");
					btnSelec.setFont(new Font("Roboto", Font.BOLD, 12));
					btnSelec.setForeground(Color.WHITE);
					btnSelec.setBorder(null);
					btnSelec.setBackground(new Color(0,51,153));
					btnSelec.setBounds(370, 162, 150, 20);
					add(btnSelec);
				
				JLabel lblGanancia = new JLabel("Ganancia Total");
				lblGanancia.setFont(new Font("Roboto", Font.BOLD, 14));
				lblGanancia.setBounds(700, 143, 150, 17);
				add(lblGanancia);
				
				JSeparator separator_V2 = new JSeparator();
				separator_V2.setForeground(new Color(0, 153, 255));
				separator_V2.setBounds(700, 185, 150, 2);
				add(separator_V2);
				
				lblTotalGanancia = new JLabel("");
				lblTotalGanancia.setFont(new Font("Roboto", Font.BOLD, 14));
				lblTotalGanancia.setBounds(700, 162, 150, 17);
				add(lblTotalGanancia);
				
					//Tabla
				JScrollPane scrollPane_D = new JScrollPane();
				scrollPane_D.setBounds(30, 200, 823, 263);
				add(scrollPane_D);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane_D.setViewportView(scrollPane);
				
				table = new JTable();
				table.setBackground(Color.WHITE);
				
				model = new DefaultTableModel();
				Object[] column = {"Id Venta","Id Producto","Fecha Venta","Precio compró" ,"Precio vende", "Cantidad", "Ganancia"};
				Object[] row = new Object[0];
				model.setColumnIdentifiers(column);
				table.setModel(model);
				
				scrollPane.setViewportView(table);
				table.setBorder(new LineBorder(new Color(0, 0, 0)));
	}

}
