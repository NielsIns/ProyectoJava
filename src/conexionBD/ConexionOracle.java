/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mabel
 */
public class ConexionOracle {

    Connection cone;
    public ConexionOracle() {
        conectar();
    }

    public Connection getCone() {
        return cone;
    }
    
    
    
    public void conectar(){
        try {
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String user="PGY2121";
            String password="duoc";
            
            Class.forName("oracle.jdbc.OracleDriver");
            
            cone=DriverManager.getConnection(url, user, password);
            System.out.println("Conectado!");
            
        } catch (Exception e) {
            System.err.println("ERROR");
        }
    }
}
