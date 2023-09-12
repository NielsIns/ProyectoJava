/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Mabel
 */
public class ValorRecaudado {
    private int precio;
    private Date fechaRecaudacion;
    private String mes;

    public ValorRecaudado() {
    }

    public ValorRecaudado(int precio, String mes) {
        this.precio = precio;
        this.mes = mes;
    }

    
    
    public ValorRecaudado(int precio, Date fechaRecaudacion) {
        this.precio=precio;
        this.fechaRecaudacion = fechaRecaudacion;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    
    
    
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) throws Exception {
        
            this.precio = precio;
        }

    public Date getFechaRecaudacion() {
        return fechaRecaudacion;
    }

    public void setFechaRecaudacion(Date fechaRecaudacion) {
        this.fechaRecaudacion = fechaRecaudacion;
    }

    @Override
    public String toString() {
        return "ValorRecaudado{" + "precio=" + precio + ", fechaRecaudacion=" + fechaRecaudacion + '}';
    }
    
    
    
    
}
