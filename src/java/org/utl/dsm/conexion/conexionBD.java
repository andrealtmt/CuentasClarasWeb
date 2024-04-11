package org.utl.dsm.conexion;
import java.sql.Connection;
import java.sql.DriverManager;

public class conexionBD {
    Connection conection;
    
    public Connection open(){
        String user = "root";
        String password = "root2024"; //Servidor
//        String password = "root"; //Local
        final String url = "jdbc:mysql://database-2.c7e2ogoyqhbn.us-east-2.rds.amazonaws.com:3306/db_cuentasclaras?useSSL=false&useUnicode=true&characterEncoding=utf-8"; //local
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conection = DriverManager.getConnection(url, user, password);
            return conection;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void close(){
        if(conection != null){
            try {
                conection.close();
            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println("Excepción controlada.");
            }
        }
    }
}
