package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import java.text.SimpleDateFormat;

public class ConsultaGanancia extends Conexion {
	public void llenarTabla(JTable table, boolean dia, java.util.Date fecha, JLabel totalGanancia ) {
		Connection con = getConnection();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		

        String formattedDate = simpleDateFormat.format(fecha);

        java.sql.Date fechita = java.sql.Date.valueOf(formattedDate);
		System.out.println("Este es el sql: "+fechita);
        
        String sql = "SELECT id_venta, fecha_venta, cantidad,id_producto, precio_unidad_producto , costo_unidad_producto, ((cantidad * precio_unidad_producto)-(cantidad * costo_unidad_producto)) ganancia "
        		+ "FROM ventas natural join detalle_ventas dv "
        		+ "NATURAL JOIN producto p "
        		+ "WHERE EXTRACT(MONTH FROM fecha_venta) = EXTRACT(MONTH FROM DATE '"+ fechita +"') AND EXTRACT(YEAR FROM fecha_venta) = EXTRACT(YEAR FROM DATE '"+ fechita +"')";
        
        if(dia) {
        	sql = sql + " AND EXTRACT(DAY FROM fecha_venta) = EXTRACT(DAY FROM DATE '"+ fechita +"')";
        }
        
        try{
        	Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
           int totalG = 0;
           while(rs.next()){
        	   
        	int id_venta = rs.getInt("id_venta");
        	int id_produ = rs.getInt("id_producto");
        	Date fecha_venta = rs.getDate("fecha_venta");
        	int costo = rs.getInt("costo_unidad_producto");
        	int precio = rs.getInt("precio_unidad_producto");
        	int cantidad = rs.getInt("cantidad");
        	int ganancia = rs.getInt("ganancia");
        	totalG = totalG + ganancia;
        	     	   
        	        	
        	Object tbData[] = {id_venta, id_produ, fecha_venta, costo, precio, cantidad, ganancia};
        	
        	DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
        	
        	tblModel.addRow(tbData);
           }
        
           totalGanancia.setText("$ "+ totalG);
           
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
