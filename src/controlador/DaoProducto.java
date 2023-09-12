/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.sun.glass.ui.Pixels.Format;
import conexionBD.ConexionOracle;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import modelo.LitrosPorCliente;
import modelo.Producto;
import modelo.ValorRecaudado;

/**
 *
 * @author Mabel
 */
public class DaoProducto {
    ConexionOracle cone;
    PreparedStatement prepare;
    
    
    public DaoProducto() {
        cone=new ConexionOracle();
    }
    
    public boolean agregarProducto(Producto p){
        boolean respuesta=false;
        try {
            String sql="INSERT INTO PRODUCTO VALUES(?,?,?,?,?)";
            prepare = cone.getCone().prepareStatement(sql);
            prepare.setInt(1, p.getCodigo());
            prepare.setString(2, p.getNombre());
            prepare.setDouble(3, p.getCantidad());
            //prepare.setDate(4, (Date) p.getFechaEnvasado());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String s = formatter.format(p.getFechaEnvasado());
                Date date=Date.valueOf(s);
            prepare.setDate(4, date);
            prepare.setInt(5, p.getPrecio());
            
            prepare.executeQuery();
            respuesta = true;
        } catch (Exception e) {
            respuesta=false;
        }
        return respuesta;
    }
    
    public boolean eliminarProducto(int codigo){
        boolean respuesta=false;
        try {
            String sql="DELETE FROM PRODUCTO WHERE CODIGO_PRODUCTO = ?";
            prepare = cone.getCone().prepareStatement(sql);
            prepare.setInt(1, codigo);
            prepare.executeQuery();
            respuesta=true;
        } catch (Exception e) {
            respuesta = false;
        }
        return respuesta;
    }
    
    public Producto buscarProducto(int codigo){
        Producto p = new Producto();
        try {
            String sql = "SELECT NOMBRE, CANTIDAD, FECHA_ENVASADO, PRECIO FROM PRODUCTO WHERE CODIGO_PRODUCTO = ?";
            prepare = cone.getCone().prepareStatement(sql);
            prepare.setInt(1, codigo);
            ResultSet rs = prepare.executeQuery();
            while (rs.next()) {               
                p.setCodigo(codigo);
                p.setNombre(rs.getString("NOMBRE"));
                p.setCantidad(rs.getDouble("CANTIDAD"));
                p.setFechaEnvasado(rs.getDate("FECHA_ENVASADO"));
                p.setPrecio(rs.getInt("PRECIO"));
                
                
            }
            
            
        } catch (Exception e) {
           
        }
        return p;
    }
    
    
    public boolean modificarProducto(Producto p){
        boolean respuesta = false;
        try {
            
            String sql = "UPDATE PRODUCTO SET NOMBRE = ?, CANTIDAD = ?, FECHA_ENVASADO = ?, PRECIO = ? WHERE CODIGO_PRODUCTO = ?";
            prepare = cone.getCone().prepareStatement(sql);
            prepare.setString(1, p.getNombre());
            prepare.setDouble(2, p.getCantidad());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String s = formatter.format(p.getFechaEnvasado());
                Date date=Date.valueOf(s);
            prepare.setDate(3, date);
            prepare.setInt(4, p.getPrecio());
            prepare.setInt(5, p.getCodigo());
            
            prepare.executeQuery();
            respuesta = true;
            
            
        } catch (Exception e) {
            respuesta = false;
        }
        return respuesta;
    }
    
    public List<Producto> listarProductos(){
        List<Producto> lista=new ArrayList<>();
        try {
            String sql = "SELECT CODIGO_PRODUCTO, NOMBRE, CANTIDAD, FECHA_ENVASADO, PRECIO FROM PRODUCTO";
            prepare= cone.getCone().prepareStatement(sql);
            
            ResultSet rs = prepare.executeQuery();
            
            
            while (rs.next()) {
                Producto p = new Producto();
                p.setCodigo(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCantidad(rs.getDouble(3));
                p.setFechaEnvasado(rs.getDate(4));
                p.setPrecio(rs.getInt(5));
                lista.add(p);
                
            }
            
            
        } catch (Exception e) {
            int v =0;
        }
        return lista;
        
    }
    
    public List<ValorRecaudado> listarValorRecaudadoDia(){
        List<ValorRecaudado> lista=new ArrayList<>();
        try {
            String sql = "SELECT SUM(p.PRECIO), v.FECHA_VENTA FROM PRODUCTO p INNER JOIN VENTA v ON v.CODIGO_PRODUCTO = p.CODIGO_PRODUCTO GROUP BY EXTRACT(day FROM FECHA_VENTA), v.FECHA_VENTA";
            prepare = cone.getCone().prepareStatement(sql);
            
            ResultSet rs = prepare.executeQuery();
            
            while (rs.next()) {                
                int valorRec=rs.getInt(1);
                Date fechaRec = rs.getDate(2);
                
                ValorRecaudado vr = new ValorRecaudado(valorRec, fechaRec);
                /*ven.getVendedor().setRut(rs.getString(1));
                ven.setFechaVenta((rs.getDate(2*/
                

                //Venta ven= new Venta(ventaFecha, producto, vendedor);
                lista.add(vr);
                
                
            }
            
            
        } catch (Exception e) {
            int a=0;
        }return lista;
    }
    
    public List<ValorRecaudado> listarValorRecaudadoMes(){
        List<ValorRecaudado> lista=new ArrayList<>();
        try {
            String sql = "SELECT SUM(p.PRECIO), TO_CHAR(v.FECHA_VENTA, 'MONTH') FROM PRODUCTO p INNER JOIN VENTA v ON v.CODIGO_PRODUCTO = p.CODIGO_PRODUCTO GROUP BY TO_CHAR(v.FECHA_VENTA, 'MONTH')";
            prepare = cone.getCone().prepareStatement(sql);
            
            ResultSet rs = prepare.executeQuery();
            
            while (rs.next()) {                
                int valorRec=rs.getInt(1);
               
               
                String fechaRec = rs.getString(2);
                
                ValorRecaudado vr = new ValorRecaudado(valorRec, fechaRec);
                /*ven.getVendedor().setRut(rs.getString(1));
                ven.setFechaVenta((rs.getDate(2*/
                

                //Venta ven= new Venta(ventaFecha, producto, vendedor);
                lista.add(vr);
                
                
            }
            
            
        } catch (Exception e) {
            int a=0;
        }return lista;
    }
    
    
        public List<LitrosPorCliente> listarLitrosCliente(){
        List<LitrosPorCliente> lista=new ArrayList<>();
        try {
            String sql = "SELECT SUM(p.CANTIDAD), c.NOMBRE_COMPLETO FROM PRODUCTO p INNER JOIN VENTA v ON v.codigo_producto = p.CODIGO_PRODUCTO INNER JOIN CLIENTE c ON v.RUT_CLIENTE=c.RUT GROUP BY c.RUT, c.NOMBRE_COMPLETO";
            prepare = cone.getCone().prepareStatement(sql);
            
            ResultSet rs = prepare.executeQuery();
            
            while (rs.next()) {                
                double cantidadLitros=rs.getDouble(1);
                String nombreCliente = rs.getString(2);
                
                LitrosPorCliente lpc = new LitrosPorCliente(cantidadLitros, nombreCliente);
                /*ven.getVendedor().setRut(rs.getString(1));
                ven.setFechaVenta((rs.getDate(2*/
                

                //Venta ven= new Venta(ventaFecha, producto, vendedor);
                lista.add(lpc);
                
                
            }
            
            
        } catch (Exception e) {
            int a=0;
        }return lista;
    }
    
}
