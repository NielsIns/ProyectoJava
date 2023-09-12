/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexionBD.ConexionOracle;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.CantidadVenta;
import modelo.Cliente;
import modelo.ParametrosVenta;
import modelo.Producto;
import modelo.ProductosVendidos;
import modelo.Vendedor;
import modelo.Venta;

/**
 *
 * @author Mabel
 */
public class DaoVenta {
    ConexionOracle cone;
    PreparedStatement prepare;
    
    
    public DaoVenta() {
        cone=new ConexionOracle();
    }
    
    public boolean agregarVenta(Venta ven){
        boolean respuesta=false;
        try {
            String sql="INSERT INTO VENTA VALUES(?,?,?,?)";
            prepare = cone.getCone().prepareStatement(sql);
            prepare.setString(1, ven.getCliente().getRut());
            prepare.setString(2, ven.getVendedor().getRut());
            prepare.setInt(3, ven.getProducto().getCodigo());
            prepare.setDate(4,Date.valueOf(LocalDate.now()));
            prepare.executeQuery();
            respuesta = true;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            respuesta=false;
        } 
        return respuesta;
    }
    
    public boolean eliminarVenta(String r, String u, int cod){
        boolean respuesta=false;
        try {
            String sql="DELETE FROM VENDEDOR WHERE RUT_CLIENTE = ? AND RUT_VENDEDOR = ? AND CODIGO_PRODUCTO = ?";
            prepare = cone.getCone().prepareStatement(sql);
            prepare.setString(1,r);
            prepare.setString(2, u);
            prepare.setInt(3, cod);
            prepare.executeQuery();
            respuesta=true;
        } catch (Exception e) {
            respuesta = false;
        }
        return respuesta;
    }
    
    
    public Venta buscarVenta(String r,String u, int cod){
        Venta ven = new Venta();
        
        try {
            String sql = "SELECT FECHA_VENTA FROM VENTA WHERE RUT_CLIENTE = ? AND RUT_VENDEDOR = ? AND CODIGO_PRODUCTO = ?";
            prepare = cone.getCone().prepareStatement(sql);
            prepare.setString(1, r);
            prepare.setString(2, u);
            prepare.setInt(3, cod);
            ResultSet rs = prepare.executeQuery();
            String rutCli="";
            String rutVen="";
            int codi=0;
            Date fecha;
            Cliente c = new Cliente(r);
            Vendedor v = new Vendedor(u);
            Producto p= new Producto(cod);
                    
                    
                    
            while (rs.next()) {               
                ven.setCliente(c);
                ven.setVendedor(v);
                ven.setCodigoProducto(p);
                ven.setFechaVenta(rs.getDate("FECHA_VENTA"));
            }
             
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ven;
    }
    
    public boolean modificarVenta(Venta ven){
        boolean respuesta = false;
        try {
            
            String sql = "UPDATE VENTA SET FECHA_VENTA=? WHERE RUT_CLIENTE = ? AND RUT_VENDEDOR = ? AND CODIGO_PRODUCTO=?";
            prepare = cone.getCone().prepareStatement(sql);
            /*java.util.Date date1=new java.util.Date();
            java.sql.Date date2=new java.sql.Date(stock_date.getTime());*/
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String s = formatter.format(ven.getFechaVenta());
                Date date=Date.valueOf(s);
            prepare.setDate(1, date);
            prepare.setString(2, ven.getCliente().getRut());
            prepare.setString(3, ven.getVendedor().getRut());
            prepare.setInt(4, ven.getProducto().getCodigo());
            
            prepare.executeQuery();
            respuesta = true;
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            respuesta = false;
            
        }
        return respuesta;
    }
    
    
    public List<ParametrosVenta> listarVentas(){
        List<ParametrosVenta> lista=new ArrayList<>();
        try {
            String sql = "SELECT RUT_CLIENTE, RUT_VENDEDOR, CODIGO_PRODUCTO, FECHA_VENTA  FROM VENTA";
            prepare= cone.getCone().prepareStatement(sql);
            
            ResultSet rs = prepare.executeQuery();
            
            
            while (rs.next()) {
                
                String rutCliente = rs.getString(1);
                String rutVendedor = rs.getString(2);
                int codProd = rs.getInt(3);
                Date fechaVenta = rs.getDate(4);
                
                ParametrosVenta lv = new ParametrosVenta(rutCliente, rutVendedor, codProd, fechaVenta);
                /*ven.getCliente().setRut(rs.getString(1));
                ven.getVendedor().setRut(rs.getString(2));
                ven.getProducto().setCodigo(rs.getInt(3));
                ven.setFechaVenta(rs.getDate(4));*/
                lista.add(lv);
                
            }
            
            
        } catch (Exception e) {
        }
        return lista;
        
    }
    
    public List<CantidadVenta> listarVentasDiarias(){
        List<CantidadVenta> lista=new ArrayList<>();
        try {
                String sql = "SELECT RUT_VENDEDOR, FECHA_VENTA, COUNT(RUT_VENDEDOR) FROM VENTA GROUP BY  RUT_VENDEDOR, FECHA_VENTA";
            prepare = cone.getCone().prepareStatement(sql);
            
            ResultSet rs = prepare.executeQuery();
            
            while (rs.next()) {                
                String rutVendedor=rs.getString(1);
                Date ventaFecha = rs.getDate(2);
                int contador = rs.getInt(3);
                CantidadVenta cv = new CantidadVenta(rutVendedor, ventaFecha, contador);
                /*ven.getVendedor().setRut(rs.getString(1));
                ven.setFechaVenta((rs.getDate(2*/
                

                //Venta ven= new Venta(ventaFecha, producto, vendedor);
                lista.add(cv);
                
                
            }
            
            
        } catch (Exception e) {
            int a=0;
        }return lista;
    }
    
    
    
    public List<ProductosVendidos> listarProductosVendidos(){
        List<ProductosVendidos> lista=new ArrayList<>();
        try {
                String sql = "SELECT COUNT(v.CODIGO_PRODUCTO), p.NOMBRE FROM VENTA v INNER JOIN PRODUCTO p ON v.codigo_producto = p.CODIGO_PRODUCTO GROUP BY p.NOMBRE ORDER BY COUNT(v.CODIGO_PRODUCTO)";
            prepare = cone.getCone().prepareStatement(sql);
            
            ResultSet rs = prepare.executeQuery();
            
            while (rs.next()) {                
                int cantidad=rs.getInt(1);
                String nombreProd = rs.getString(2);
                
                ProductosVendidos pv = new ProductosVendidos(cantidad, nombreProd);
                /*ven.getVendedor().setRut(rs.getString(1));
                ven.setFechaVenta((rs.getDate(2*/
                

                //Venta ven= new Venta(ventaFecha, producto, vendedor);
                lista.add(pv);
                
                
            }
            
            
        } catch (Exception e) {
            int a=0;
        }return lista;
    }
    
    
}
