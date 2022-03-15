package modelo;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultarArticuloReporte extends Conexion {
	
	public void llenarTabla(JTable table) {
		Connection con = getConnection();
        String sql = "SELECT * FROM producto WHERE cantidad_producto < 10";
        
        try{
        	Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
           
           while(rs.next()){
        	   
        	int id_producto = rs.getInt("id_producto");
        	String referencia_producto = rs.getString("referencia_producto");
        	int id_proveedor = rs.getInt("id_proveedor");
        	int cantidad_producto = rs.getInt("cantidad_producto");
        	int costo_unidad_producto = rs.getInt("costo_unidad_producto");
        	String tipo_calzado = rs.getString("tipo_calzado");
        	String marca_producto = rs.getString("marca_producto");
        	String talla_producto = rs.getString("talla_producto");
        	String color_producto = rs.getString("color_producto");
        	   
        	
        	
        	Object tbData[] = {id_producto, referencia_producto, id_proveedor, cantidad_producto, costo_unidad_producto, 
        			tipo_calzado, marca_producto, talla_producto, color_producto  };
        	
        	DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
        	
        	tblModel.addRow(tbData);
           }
        	
           
        }catch(SQLException e) {
            System.err.println(e);

        } finally{
            try{
                con.close();
            }catch (SQLException e){
                System.err.println(e);
            }
        }
        
	}
	
}
