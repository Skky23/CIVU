package ventanas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class VentanaReporte extends JPanel {
	public JButton btnVerVentas;
	public JButton btnVerInventario;
	public JButton btnVerDescuentos;
	
	//VENTAS
	public JComboBox comboBoxVentas;
	
	//INVENTARIO
	public JTable table;
	DefaultTableModel model;
	
	
	//Objetos de la clase JPanel
	public VentanaGanancias ganancias;
	public VentanaAbastecer abastecer;
	public VentanaDescuentos descuentos;
	/**
	 * Create the panel.
	 */
	public VentanaReporte() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		//Titulo
		JLabel lblNewLabel = new JLabel("Reportes");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 260, 26);
		add(lblNewLabel);
	
		ganancias = new VentanaGanancias();
		abastecer = new VentanaAbastecer();
		descuentos = new VentanaDescuentos();
		
		
				
		//Botones
		btnVerVentas = new JButton("GANANCIAS");
		btnVerVentas.setFont(new Font("Roboto", Font.BOLD, 12));
		btnVerVentas.setForeground(Color.WHITE);
		btnVerVentas.setBorder(null);
		btnVerVentas.setBackground(new Color(0,51,153));
		btnVerVentas.setBounds(30, 78, 113, 25);
		add(btnVerVentas);
		
		btnVerInventario = new JButton("ABASTECER");
		btnVerInventario.setForeground(Color.WHITE);
		btnVerInventario.setFont(new Font("Roboto", Font.BOLD, 12));
		btnVerInventario.setBorder(null);
		btnVerInventario.setBackground(new Color(0, 51, 153));
		btnVerInventario.setBounds(153, 78, 113, 25);
		add(btnVerInventario);
		
		btnVerDescuentos = new JButton("DESCUENTOS");
		btnVerDescuentos.setForeground(Color.WHITE);
		btnVerDescuentos.setFont(new Font("Roboto", Font.BOLD, 12));
		btnVerDescuentos.setBorder(null);
		btnVerDescuentos.setBackground(new Color(0, 51, 153));
		btnVerDescuentos.setBounds(276, 78, 113, 25);
		add(btnVerDescuentos);
		
		//Separador
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 153, 255));
		separator.setBounds(30, 123, 828, 2);
		add(separator);
		
		//Agregarlos
		add(ganancias);
		add(abastecer);
		add(descuentos);
		
		//Visibles
		ganancias.setVisible(false);
		abastecer.setVisible(false);
		descuentos.setVisible(false);
		
		
		
		
	}
}
