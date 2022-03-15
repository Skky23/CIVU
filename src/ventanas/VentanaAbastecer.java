package ventanas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class VentanaAbastecer extends JPanel{
	public JComboBox comboBoxVentas;
	public JTable table;
	DefaultTableModel model;
	
	/**
	 * Create the panel.
	 */
	public VentanaAbastecer() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		setSize(885, 485);
		setLocation(0, 0);
		
		//INVENTARIO
				JLabel lblComprar = new JLabel("PRODUCTOS QUE REQUIEREN SER ABASTECIDOS:");
				lblComprar.setFont(new Font("Roboto", Font.BOLD, 14));
				lblComprar.setBounds(30, 143, 365, 17);
				add(lblComprar);
				
				JScrollPane scrollPane_I = new JScrollPane();
				scrollPane_I.setBounds(30, 180, 823, 283);
				add(scrollPane_I);
				
					//Tabla
				JScrollPane scrollPane = new JScrollPane();
				scrollPane_I.setViewportView(scrollPane);
				
				table = new JTable();
				table.setBackground(Color.WHITE);
				
				model = new DefaultTableModel();
				Object[] column = {"ID", "Referencia", "Proveedor","Cantidad","Costo","Tipo","Marca","Talla","Color"};
				Object[] row = new Object[0];
				model.setColumnIdentifiers(column);
				table.setModel(model);
				
				scrollPane.setViewportView(table);
				table.setBorder(new LineBorder(new Color(0, 0, 0)));
	}

}
