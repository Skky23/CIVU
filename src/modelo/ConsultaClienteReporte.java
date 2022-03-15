package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultaClienteReporte extends Conexion {
	public void llenarTabla(JTable table, boolean dia) {
		Connection con = getConnection();
        String sql = "SELECT * FROM cliente "
        		+ "WHERE EXTRACT(MONTH FROM fecha_nacimiento_cliente) = EXTRACT(MONTH FROM NOW())";
        
        if(dia) {
        	sql = sql + " AND EXTRACT(DAY FROM fecha_nacimiento_cliente) = EXTRACT(DAY FROM NOW())";
        }
        
        try{
        	Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
           
           while(rs.next()){
        	   
        	int id = rs.getInt("cedula_cliente");
        	String nombre = rs.getString("nombre_cliente");
        	Date fechaNacimiento = rs.getDate("fecha_nacimiento_cliente");
        	   
        	
        	
        	Object tbData[] = {id, nombre, fechaNacimiento};
        	
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
