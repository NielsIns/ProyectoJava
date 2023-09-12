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
public class Venta {
    int contador = 0;
    
    private Date fechaVenta, fechaEntrega;
    private int totalPagar;
    private String observaciones;
    private Producto producto;
    private Vendedor vendedor;
    private Cliente cliente;

    public Venta() {
    }

    public Venta(Date fechaVenta, Producto producto, Vendedor vendedor, Cliente cliente) {
        this.fechaVenta = fechaVenta;
        this.producto = producto;
        this.vendedor = vendedor;
        this.cliente = cliente;
    }
    
    
    
    

    public Venta(Date fechaVenta, Producto producto, Vendedor vendedor) {
        this.fechaVenta = fechaVenta;
        this.producto = producto;
        this.vendedor = vendedor;
    }
    
    
    
    
    public Venta(Date fechaVenta, Date fechaEntrega, int totalPagar, String observaciones, Producto producto, Vendedor vendedor, Cliente cliente) {
        this.fechaVenta = fechaVenta;
        this.fechaEntrega = fechaEntrega;
        this.totalPagar = totalPagar;
        this.observaciones = observaciones;
        this.producto = producto;
        this.vendedor = vendedor;
        this.cliente = cliente;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setCodigoProducto(Producto producto) {
        this.producto = producto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Venta{" + "fechaVenta=" + fechaVenta + ", fechaEntrega=" + fechaEntrega + ", totalPagar=" + totalPagar + ", observaciones=" + observaciones + ", codigoProducto=" + producto + ", vendedor=" + vendedor + ", cliente=" + cliente + '}';
    }
    
    
    
}
