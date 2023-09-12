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
public class CantidadVenta {
  
    private String rutVendedor;
    private Date envasadoFecha;
    private int cantidadVenta;

    public CantidadVenta() {
    }

    public CantidadVenta(String rutVendedor, Date envasadoFecha, int cantidadVenta) {
        this.rutVendedor = rutVendedor;
        this.envasadoFecha = envasadoFecha;
        this.cantidadVenta = cantidadVenta;
    }

    public int getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(int cantidadVenta) throws Exception {
        
        if (String.valueOf(cantidadVenta).length ()>=1){
            this.cantidadVenta = cantidadVenta;
        }else{
            throw new Exception ("Error, debe ingresar un valor");
        }
    }
    

    public String getRutVendedor() {
        return rutVendedor;
    }

    public void setRutVendedor(String rutVendedor) throws Exception {
        if (String.valueOf(rutVendedor).length()>=9 && String.valueOf (rutVendedor).length ()<=10){
            this.rutVendedor =rutVendedor;
        }else{
            throw new Exception("Error, el rut debe tener una longitud mayor a 9 y menor a 10");
        }
    }

    public Date getEnvasadoFecha() {
        return envasadoFecha;
    }

    public void setEnvasadoFecha(Date envasadoFecha) {
        this.envasadoFecha = envasadoFecha;
    }

    @Override
    public String toString() {
        return "CantidadVenta{" + "rutVendedor=" + rutVendedor + ", envasadoFecha=" + envasadoFecha + '}';
    }
    
    
    
}
