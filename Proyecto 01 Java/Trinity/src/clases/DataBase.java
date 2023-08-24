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
    
    public boolean insertarUsuario(String cedula, String nombre, String contrasena, String rol){
        
        boolean respuesta = false;
        
        try {
            String consulta = "INSERT INTO usuarios (Cedula, Nombre, Contrasena, Rol) VALUES('"+cedula+"','"+nombre+"','"+contrasena+"','"+rol+"')";
            int resultado = this.manipularDB.executeUpdate(consulta);
            if (resultado==1){
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.print("Error al insertar: " + ex.getMessage());
        }   
        
        return respuesta;        
    }
    
    public ResultSet iniciarSesion(String cedula, String contrasena) {
        ResultSet persona = null;
        try {
            String consulta = "SELECT * FROM usuarios WHERE cedula = " + cedula + " AND contrasena = '" + contrasena + "'";
            persona = this.manipularDB.executeQuery(consulta);
        } catch (SQLException ex) {
            System.out.print("Error al iniciar sesion: " + ex.getMessage());
        }
        return persona;
    }
    
    public ResultSet buscarUsuario(String cedula) {
        ResultSet persona = null;
        try {
            String consulta = "SELECT * FROM usuarios WHERE cedula = " + cedula + "";
            persona = this.manipularDB.executeQuery(consulta);
            if (persona.next()){
                return persona;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            System.out.print("Error al buscar usuario: " + ex.getMessage());
        }
        return persona;
    }
    
    public boolean actualizarUsuarios(String cedula, String nombre, String contrasena, String rol) {
        boolean respuesta = false;
        try {
            String consulta = "UPDATE usuarios SET nombre = '" + nombre + "', contrasena = '" + contrasena + "', rol = '" + rol + "' WHERE cedula = '" + cedula + "'";
            int resultado = this.manipularDB.executeUpdate(consulta);
            respuesta = (resultado == 1);
        } catch (SQLException ex) {
            System.out.print("Error al actualizar persona: " + ex.getMessage());
        }
    return respuesta;
    }


    
}
