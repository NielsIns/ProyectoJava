/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexionBD.ConexionOracle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Vendedor;


/**
 *
 * @author Mabel
 */
public class DaoVendedor {
    
    ConexionOracle cone;
    PreparedStatement prepare;
    
    
    public DaoVendedor() {
        cone=new ConexionOracle();
    }
    
    public boolean agregarVendedor(Vendedor v){
        boolean respuesta=false;
        try {
            String sql="INSERT INTO VENDEDOR VALUES(?,?,?,?,?)";
            prepare = cone.getCone().prepareStatement(sql);
            prepare.setString(1, v.getRut());
            prepare.setString(2, v.getNombreCompleto());
            prepare.setString(3, v.getDireccion());
            prepare.setInt(4, v.getTelefono());
            prepare.setString(5, v.getCorreoElectronico());
            
            prepare.executeQuery();
            respuesta = true;
        } catch (Exception e) {
            respuesta=false;
        }
        return respuesta;
    }
    
    public boolean eliminarVendedor(String rut){
        boolean respuesta=false;
        try {
            String sql="DELETE FROM VENDEDOR WHERE rut = ?";
            prepare = cone.getCone().prepareStatement(sql);
            prepare.setString(1, rut);
            prepare.executeQuery();
            respuesta=true;
        } catch (Exception e) {
            respuesta = false;
        }
        return respuesta;
    }
    
    public Vendedor buscarVendedor(String rut){
        Vendedor v = new Vendedor();
        try {
            String sql = "SELECT NOMBRE_COMPLETO, DIRECCION, TELEFONO, CORREO FROM VENDEDOR WHERE rut = ?";
            prepare = cone.getCone().prepareStatement(sql);
            prepare.setString(1, rut);
            ResultSet rs = prepare.executeQuery();
            while (rs.next()) {               
                v.setRut(rut);
                v.setNombreCompleto(rs.getString("NOMBRE_COMPLETO"));
                v.setDireccion(rs.getString("DIRECCION"));
                v.setTelefono(rs.getInt("TELEFONO"));
                v.setCorreoElectronico(rs.getString("CORREO"));
                
                
            }
            
            
        } catch (Exception e) {
           
        }
        return v;
    }
    
    
    public boolean modificarVendedor(Vendedor v){
        boolean respuesta = false;
        try {
            
            String sql = "UPDATE VENDEDOR SET NOMBRE_COMPLETO = ?, DIRECCION = ?, TELEFONO = ?, CORREO = ? WHERE RUT = ?";
            prepare = cone.getCone().prepareStatement(sql);
            prepare.setString(1, v.getNombreCompleto());
            prepare.setString(2, v.getDireccion());
            prepare.setInt(3, v.getTelefono());
            prepare.setString(4, v.getCorreoElectronico());
            prepare.setString(5, v.getRut());
            
            prepare.executeQuery();
            respuesta = true;
            
            
        } catch (Exception e) {
            respuesta = false;
        }
        return respuesta;
    }
    
    public List<Vendedor> listarVendedores(){
        List<Vendedor> lista=new ArrayList<>();
        try {
            String sql = "SELECT RUT, NOMBRE_COMPLETO, DIRECCION, TELEFONO, CORREO FROM VENDEDOR";
            prepare= cone.getCone().prepareStatement(sql);
            
            ResultSet rs = prepare.executeQuery();
            
            
            while (rs.next()) {
                Vendedor v = new Vendedor();
                v.setRut(rs.getString(1));
                v.setNombreCompleto(rs.getString(2));
                v.setDireccion(rs.getString(3));
                v.setTelefono(rs.getInt(4));
                v.setCorreoElectronico(rs.getString(5));
                lista.add(v);
                
            }
            
            
        } catch (Exception e) {
        }
        return lista;
        
    }
    
   
    
}
