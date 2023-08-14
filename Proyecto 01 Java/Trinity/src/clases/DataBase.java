package clases;

import java.sql.*;


public class DataBase {
    
    Connection conexion;
    Statement manipularDB;
    
    public DataBase (){
        String hostname = "localhost";
        String user_name = "root";
        String database_name = "trinity_bd";
        String puerto = "3306";
        String password = "";
        
        String url = "jdbc:mysql://"+hostname+":"+puerto+"/"+database_name;
        
        try {
            this.conexion = DriverManager.getConnection(url, user_name, password);
            this.manipularDB = this.conexion.createStatement();
            System.out.print("Conexion a DataBase exitosa");
        } catch (SQLException ex) {
            System.out.print("Error en conexion a base de datos: " + ex.getMessage());
        }
    }
}
