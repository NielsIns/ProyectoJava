/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Mabel
 */
public class ProductosVendidos {
    private int cantidadProd;
    private String nombreProd;

    public ProductosVendidos() {
    }

    public ProductosVendidos(int cantidadProd, String nombreProd) throws Exception {
        setCantidadProd(cantidadProd);
        setNombreProd(nombreProd);
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public void setCantidadProd(int cantidadProd) throws Exception {
        
            this.cantidadProd = cantidadProd;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) throws Exception {
        
            this.nombreProd = nombreProd;
    }

    @Override
    public String toString() {
        return "ProductosVendidos{" + "cantidadProd=" + cantidadProd + ", nombreProd=" + nombreProd + '}';
    }
    
    
    
    
    
}
