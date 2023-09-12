/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexionBD.ConexionOracle;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Cliente;
import oracle.jdbc.OracleConnection;

/**
 *
 * @author Mabel
 */
public class DaoCliente {

    ConexionOracle cone;
    PreparedStatement prepare;
    
    
    public DaoCliente() {
        cone=new ConexionOracle();
    }
    
    public boolean agregarCliente(Cliente c){
        boolean respuesta=false;
        try {
            String sql="INSERT INTO CLIENTE VALUES(?,?,?,?,?,?)";
            prepare = cone.getCone().prepareStatement(sql);
            prepare.setString(1, c.getRut());
            prepare.setString(2, c.getNombreCompleto());
            prepare.setString(3, c.getDireccion());
            prepare.setString(4, c.getComuna());
            prepare.setInt(5, c.getTelefono());
            prepare.setString(6, c.getCorreoElectronico());
            
            prepare.executeQuery();
            respuesta = true;
        } catch (Exception e) {
            respuesta=false;
            System.out.println(""+e.getMessage());
        }
        return respuesta;
    }
    
    public boolean eliminarCliente(String rut){
        boolean respuesta=false;
        try {
            String sql="DELETE FROM CLIENTE WHERE rut = ?";
            prepare = cone.getCone().prepareStatement(sql);
            prepare.setString(1, rut);
            prepare.executeQuery();
            respuesta=true;
        } catch (Exception e) {
            respuesta = false;
        }
        return respuesta;
    }
    
    public Cliente buscarCliente(String rut){
        Cliente c = new Cliente();
        try {
            String sql = "SELECT NOMBRE_COMPLETO, DIRECCION, COMUNA, TELEFONO, CORREO FROM CLIENTE WHERE rut = ?";
            prepare = cone.getCone().prepareStatement(sql);
            prepare.setString(1, rut);
            ResultSet rs = prepare.executeQuery();
            while (rs.next()) {               
                c.setRut(rut);
                c.setNombreCompleto(rs.getString("NOMBRE_COMPLETO"));
                c.setDireccion(rs.getString("DIRECCION"));
                c.setComuna(rs.getString("COMUNA"));
                c.setTelefono(rs.getInt("TELEFONO"));
                c.setCorreoElectronico(rs.getString("CORREO"));
                
                
            }
            
            
        } catch (Exception e) {
           
        }
        return c;
    }
    
    
    public boolean modificarCliente(Cliente c){
        boolean respuesta = false;
        try {
            
            String sql = "UPDATE CLIENTE SET NOMBRE_COMPLETO = ?, DIRECCION = ?, COMUNA = ?, TELEFONO = ?, CORREO = ? WHERE RUT = ?";
            prepare = cone.getCone().prepareStatement(sql);
            prepare.setString(1, c.getNombreCompleto());
            prepare.setString(2, c.getDireccion());
            prepare.setString(3, c.getComuna());
            prepare.setInt(4, c.getTelefono());
            prepare.setString(5, c.getCorreoElectronico());
            prepare.setString(6, c.getRut());
            
            prepare.executeQuery();
            respuesta = true;
            
            
        } catch (Exception e) {
            respuesta = false;
        }
        return respuesta;
    }
    
    public List<Cliente> listarClientes(){
        List<Cliente> lista=new ArrayList<>();
        try {
            String sql = "SELECT RUT, NOMBRE_COMPLETO, DIRECCION, COMUNA, TELEFONO, CORREO FROM CLIENTE";
            prepare= cone.getCone().prepareStatement(sql);
            
            ResultSet rs = prepare.executeQuery();
            
            
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setRut(rs.getString(1));
                c.setNombreCompleto(rs.getString(2));
                c.setDireccion(rs.getString(3));
                c.setComuna(rs.getString(4));
                c.setTelefono(rs.getInt(5));
                c.setCorreoElectronico(rs.getString(6));
                lista.add(c);
                
            }
            
            
        } catch (Exception e) {
        }
        return lista;
        
    }
    
    
}
