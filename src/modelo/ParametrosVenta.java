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
public class ParametrosVenta {
    private String rutCliente, rutVendedor;
    private int codProd;
    private Date fechaVenta;

    public ParametrosVenta() {
    }

    public ParametrosVenta(String rutCliente, String rutVendedor, int codProd, Date fechaVenta) throws Exception {
        this.rutCliente = rutCliente;
        this.rutVendedor = rutVendedor;
        setCodProd(codProd);
        this.fechaVenta = fechaVenta;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) throws Exception {
        if (String.valueOf (rutCliente).length()>=9 && String.valueOf (rutCliente).length ()<=10){
            this.rutCliente = rutCliente;
        }else{
            throw new Exception("Error, el rut debe tener una longitud mayor a 9 y menor a 10");
        }
    }

    public String getRutVendedor() {
        return rutVendedor;
    }

    public void setRutVendedor(String rutVendedor) throws Exception {
        
            this.rutVendedor = rutVendedor;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) throws Exception {

            this.codProd = codProd;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "ListarVenta{" + "rutCliente=" + rutCliente + ", rutVendedor=" + rutVendedor + ", codProd=" + codProd + ", fechaVenta=" + fechaVenta + '}';
    }
    
    
    
    
    
}
