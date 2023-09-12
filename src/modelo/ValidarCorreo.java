/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hp
 */
public class ValidarCorreo {

    public ValidarCorreo() {
    }
    
    
    
    
    public static boolean isEmail(String correo) { 
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-za-z0-9-]+\\.)+[A-za-z]{2,4}");
        mat = pat.matcher(correo);
        return mat.matches();

    }

    static public boolean isNum(String num) {

        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("[0-9]+");
        mat = pat.matcher(num);

        if (mat.matches()) {
            return true;
        } else {
            return false;
        }

    }

    static public boolean isCadena(String num) {

        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("[A-za-z]+");
        mat = pat.matcher(num);

        if (mat.matches()) {
            return true;
        } else {
            return false;
        }

    }

}
