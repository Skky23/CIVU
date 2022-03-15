
package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import modelo.Usuario;
import ventanas.VentanaGestionClientes;
import ventanas.VentanaGestionInventario;
import ventanas.VentanaGestionProveedores;
import ventanas.VentanaGestionUsuarios;
import ventanas.VentanaPerfil;
import ventanas.VentanaPrincipal;
import ventanas.VentanaReporte;

public class ControladorMenuPrincipal implements ActionListener{
	
	VentanaPrincipal ventanaPrincipal;
	VentanaPerfil ventanaPerfil;
	VentanaGestionUsuarios ventanaGestionUsuarios;
	VentanaGestionClientes ventanaGestionClientes;
	VentanaGestionProveedores ventanaGestionProveedores;
	VentanaGestionInventario ventanaGestionInventario;
	VentanaReporte ventanaReporte;
	ControladorPerfil controladorPerfil;
	ControladorGestionUsuarios controladorGestionUsuarios;
	ControladorGestionClientes controladorGestionClientes;
	ControladorGestionProveedores controladorGestionProveedores;
	ControladorReporte controladorReporte;
	Usuario empleado;
	
	
public ControladorMenuPrincipal(VentanaPrincipal ventanaPrincipal, Usuario empleado) {
	this.ventanaPrincipal = ventanaPrincipal;
	this.empleado = empleado;
	this.ventanaPrincipal.btnPerfil.addActionListener(this);
	this.ventanaPrincipal.btnGestionUsuarios.addActionListener(this);
	this.ventanaPrincipal.btnGestionClientes.addActionListener(this);
	this.ventanaPrincipal.btnGestionProveedores.addActionListener(this);
	this.ventanaPrincipal.btnInventario.addActionListener(this);
	this.ventanaPrincipal.btnVentas.addActionListener(this);
	this.ventanaPrincipal.btnReportes.addActionListener(this);
	this.ventanaPrincipal.btnSalir.addActionListener(this); 
}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaPrincipal.btnPerfil) {
			ventanaPerfil = new VentanaPerfil();
			controladorPerfil= new ControladorPerfil(ventanaPerfil,empleado);
			controladorPerfil.ponerInformacionUsuario();
			mostrarPanel(ventanaPerfil);
			
		}
		
		if(e.getSource() == ventanaPrincipal.btnGestionUsuarios) {
			ventanaGestionUsuarios = new VentanaGestionUsuarios();
			controladorGestionUsuarios = new ControladorGestionUsuarios(ventanaGestionUsuarios);
			mostrarPanel(ventanaGestionUsuarios);
		}
		
		if(e.getSource() == ventanaPrincipal.btnGestionClientes) {
			ventanaGestionClientes = new VentanaGestionClientes();
			controladorGestionClientes = new ControladorGestionClientes(ventanaGestionClientes);
			mostrarPanel(ventanaGestionClientes);
		}
	
		if(e.getSource() == ventanaPrincipal.btnGestionProveedores) {
			ventanaGestionProveedores = new VentanaGestionProveedores();
			controladorGestionProveedores = new ControladorGestionProveedores(ventanaGestionProveedores);
			mostrarPanel(ventanaGestionProveedores);
		}
	
		if(e.getSource() == ventanaPrincipal.btnInventario) {
			ventanaGestionInventario = new VentanaGestionInventario();
			//controlador gestion inventario
			mostrarPanel(ventanaGestionInventario);
			
		}
	
		if(e.getSource() == ventanaPrincipal.btnVentas) {
			
		}
	
		if(e.getSource() == ventanaPrincipal.btnReportes) {
			ventanaReporte = new VentanaReporte();
			controladorReporte = new ControladorReporte(ventanaReporte);
			//controlador gestion inventario
			mostrarPanel(ventanaReporte);
		}
	
		if(e.getSource() == ventanaPrincipal.btnSalir) {
			
			ventanaPrincipal.dispose();
		}
	}
	
	
	
	public void mostrarPanel(JPanel panel) {
		
		panel.setSize(885, 485);
		panel.setLocation(0, 0);
		ventanaPrincipal.panelPrincipalVentanas.removeAll();
		ventanaPrincipal.panelPrincipalVentanas.add(panel);
		ventanaPrincipal.panelPrincipalVentanas.revalidate();
		ventanaPrincipal.panelPrincipalVentanas.repaint();
	}

}
