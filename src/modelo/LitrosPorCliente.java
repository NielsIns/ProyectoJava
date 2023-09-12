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
public class LitrosPorCliente {
    private double cantidadLitros;
    private String nombreCli;

    public LitrosPorCliente() {
    }

    public LitrosPorCliente(double cantidadLitros, String nombreCli) throws Exception {
        setCantidadLitros(cantidadLitros);
        setNombreCli(nombreCli);
    }

    public double getCantidadLitros() {
        return cantidadLitros;
    }

    public void setCantidadLitros(double cantidadLitros) throws Exception {
            this.cantidadLitros = cantidadLitros;
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) throws Exception {
        
            this.nombreCli = nombreCli;
    }

    @Override
    public String toString() {
        return "LitrosPorCliente{" + "cantidadLitros=" + cantidadLitros + ", nombreCli=" + nombreCli + '}';
    }
    
    
}
