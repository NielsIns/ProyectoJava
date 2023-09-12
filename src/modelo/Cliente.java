/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static modelo.ValidarCorreo.isEmail;

        

/**
 *
 * @author Mabel
 */
public class Cliente {
    private String rut, nombreCompleto, direccion, correoElectronico;
    private int telefono;
    private String comuna;

    public Cliente() {
    }

    public Cliente(String rut) {
        this.rut = rut;
    }
    
    

    public Cliente(String rut, String nombreCompleto, String direccion, String correoElectronico, int telefono, String comuna) throws Exception {
        this.rut = rut;
        setNombreCompleto(nombreCompleto);
        setDireccion(direccion);
        setCorreoElectronico (correoElectronico);
        setTelefono(telefono);
        setComuna(comuna);
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) throws Exception {
        if (String.valueOf(rut).length()>=9 && String.valueOf (rut).length ()<=10){
            this.rut=rut;
        }else{
            throw new Exception("Error, el rut debe tener una longitud mayor a 9 y menor a 10");
        }
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) throws Exception {
        if (nombreCompleto.trim().length()>3) {
            this.nombreCompleto = nombreCompleto;
        }else{
            throw new Exception("Error, el nombre debe tener mas de 3 caracteres");
        }

    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) throws Exception {
        if (direccion.trim().length ()!=10) {
            this.direccion = direccion;   
        }else{
            throw new Exception("Error, la dirección debe tener un minimo de 10 caracteres");
        }
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) throws Exception {
        ValidarCorreo vc = new ValidarCorreo();
        
        if (vc.isEmail(correoElectronico)){
            this.correoElectronico = correoElectronico;
        }
        else{
            throw new Exception("Ha ingresado un correo no valido");
        }
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) throws Exception {
        
        if (String.valueOf(telefono).length ()>=9){
            this.telefono = telefono;
        }else{
            throw new Exception ("Error el número debe tener 9 digitos");
        }
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) throws Exception {
        if (comuna.trim().length ()>5) {
            this.comuna = comuna;  
        }else{
            throw new Exception("Error, la comuna debe tener un minimo de 5 caracteres");
        }
    }

    @Override
    public String toString() {
        return "Cliente{" + "rut=" + rut + ", nombreCompleto=" + nombreCompleto + ", direccion=" + direccion + ", correoElectronico=" + correoElectronico + ", telefono=" + telefono + ", comuna=" + comuna + '}';
    }

    
    
}
