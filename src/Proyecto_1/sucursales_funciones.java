package Proyecto_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class sucursales_funciones {
	
	PreparedStatement ps;
    ResultSet rs;
    Connection con;    
    conexion acceso = new conexion();
    sucursal s = new sucursal();
    
    
    public void crear (String nombre, String direccion, String correo, int telefono) {
    	String sql = "insert into sucursales(nombre,direccion,correo,telefono)values(?,?,?,?)";
    	
    	try {
    		con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setString(3, correo);
            ps.setInt(4, telefono);
            ps.executeUpdate();
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
    	
        
    }
    
    public void modificar(sucursal s) {
    	String sql = "update sucursales set nombre=?, direccion=?, correo=?, telefono=? where codigo=?";
        
    	try {
    		con = acceso.Conectar();
            ps = con.prepareStatement(sql);            
            ps.setString(1, s.getNombre());
            ps.setString(2, s.getDireccion());
            ps.setString(3, s.getCorreo());
            ps.setInt(4, s.getTelefono());
            ps.setInt(5, s.getCodigo());
            ps.executeUpdate();
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
    	
    }
    
    public void eliminar(int id) {
        String sql = "delete from sucursales where codigo=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        	System.out.println(e);
        }
    }    

}
