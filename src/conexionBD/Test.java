/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;



/**
 *
 * @author Mabel
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ConexionOracle conexion=new ConexionOracle();
        
        System.out.println(java.time.LocalDate.now().toString()); 
        
        
        
    }

    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
            
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        System.out.println(fechaDate);
        return fechaDate;
    }
    
}
