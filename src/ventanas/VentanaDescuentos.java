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

public class VentanaDescuentos extends JPanel {
	public JButton btnSelec;
	public JComboBox comboBoxCumple;
	public JTable table;
	DefaultTableModel model;
	
	/**
	 * Create the panel.
	 */
	public VentanaDescuentos() {
	setBorder(new LineBorder(new Color(0, 0, 0)));
	setBackground(new Color(255, 255, 255));
	setLayout(null);
	
	setSize(885, 485);
	setLocation(0, 0);
	
	//DESCUENTOS
			JLabel lblSelectMesDia = new JLabel("Descuento Cumpleaños");
			lblSelectMesDia.setFont(new Font("Roboto", Font.BOLD, 14));
			lblSelectMesDia.setBounds(30, 143, 180, 17);
			add(lblSelectMesDia);
			
			JSeparator separator_D = new JSeparator();
			separator_D.setForeground(new Color(0, 153, 255));
			separator_D.setBounds(30, 185, 180, 2);
			add(separator_D);
			
			comboBoxCumple = new JComboBox();
			comboBoxCumple.setBackground(Color.WHITE);
			comboBoxCumple.setFont(new Font("Roboto", Font.PLAIN, 14));
			comboBoxCumple.setModel(new DefaultComboBoxModel(new String[] {"", "Este día", "Este mes"}));
			comboBoxCumple.setBorder(null);
			comboBoxCumple.setBounds(30, 162, 180, 20);
			add(comboBoxCumple);
			
			btnSelec = new JButton("SELECCIONAR");
			btnSelec.setFont(new Font("Roboto", Font.BOLD, 12));
			btnSelec.setForeground(Color.WHITE);
			btnSelec.setBorder(null);
			btnSelec.setBackground(new Color(0,51,153));
			btnSelec.setBounds(250, 162, 150, 20);
			add(btnSelec);
			
				//Tabla
			JScrollPane scrollPane_D = new JScrollPane();
			scrollPane_D.setBounds(30, 200, 823, 263);
			add(scrollPane_D);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane_D.setViewportView(scrollPane);
			
			table = new JTable();
			table.setBackground(Color.WHITE);
			
			model = new DefaultTableModel();
			Object[] column = {"ID", "Nombre", "Cumpleaños"};
			Object[] row = new Object[0];
			model.setColumnIdentifiers(column);
			table.setModel(model);
			
			scrollPane.setViewportView(table);
			table.setBorder(new LineBorder(new Color(0, 0, 0)));
	}
}
