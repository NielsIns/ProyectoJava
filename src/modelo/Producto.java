/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Mabel
 */
public class Producto {
    
    private int  codigo, precio;
    private String nombre;
    private Date fechaEnvasado;
    private double cantidad;

    public Producto() {
    }

    public Producto(int codigo) {
        this.codigo = codigo;
    }
    
    

    public Producto(double cantidad, int codigo, int precio, String nombre, Date fechaEnvasado) throws Exception {
        setCantidad(cantidad);
        setCodigo(codigo);
        setPrecio(precio);
        setNombre(nombre);
        this.fechaEnvasado = fechaEnvasado;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) throws Exception {
        
        if (String.valueOf(cantidad).length ()>0){
            this.cantidad = cantidad;
        }else{
            throw new Exception ("Error, la cantidad de litros debe ser superior a 0");
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        
        if (String.valueOf(codigo).length ()>=6){
            this.codigo = codigo;
        }else{
            throw new Exception ("Error el código del producto debe ser mayor o igual a 6 digitos");
        }
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) throws Exception {
        
        if (precio>0){
            this.precio = precio;
        }else{
            throw new Exception ("Error el precio del producto debe ser superior a 0 pesos");
        }
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if (nombre.trim().length()>0) {
            this.nombre = nombre;
        }else{
            throw new Exception("Error, el nombre debe tener una longitud mayor a cero");
        }
    }

    public Date getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(Date fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }


    @Override
    public String toString() {
        return "Producto{" + "cantidad=" + cantidad + ", codigo=" + codigo + ", precio=" + precio + ", nombre=" + nombre + ", fechaEnvasado=" + fechaEnvasado +'}';
    }
    

    
    
    
}
