package clases;

import java.sql.*;
import java.util.ArrayList;


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

    public ArrayList<Productos> obtenerProductos() {
        ArrayList<Productos> productosList = new ArrayList<>();
        String consultaProductos = "SELECT * FROM Productos";

        try {
            ResultSet productosResult = manipularDB.executeQuery(consultaProductos);
            while (productosResult.next()) {
                Productos producto = new Productos(
                    productosResult.getString("Id_Producto"),
                    productosResult.getString("Nombre"),
                    productosResult.getString("Descripcion"),
                    productosResult.getString("Precio"),
                    productosResult.getString("CantidadStock"),
                    productosResult.getString("Url_img") 
                );

                productosList.add(producto);
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar los productos: " + ex.getMessage());
        }

        return productosList;
    }
    
    public ArrayList<Productos> obtenerCarrito() {
        ArrayList<Productos> productosList = new ArrayList<>();
        String consultaProductos = "SELECT * FROM Carrito";

        try {
            ResultSet productosResult = manipularDB.executeQuery(consultaProductos);
            while (productosResult.next()) {
                Productos producto = new Productos(
                    productosResult.getString("Id_Carrito"),
                    productosResult.getString("Nombre"),
                    productosResult.getString("Descripcion"),
                    productosResult.getString("Precio"),
                    productosResult.getString("CantidadStock"),
                    productosResult.getString("Url_img") 
                );

                productosList.add(producto);
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar los productos: " + ex.getMessage());
        }

        return productosList;
    }
    
    public boolean agregarAlCarrito(Productos producto) {
        boolean respuesta = false;
        
        try {
            String consulta = "INSERT INTO Carrito (Nombre, Descripcion, Precio, CantidadStock, Url_img) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setString(2, producto.getDescripcion());
            preparedStatement.setString(3, producto.getPrecio());
            preparedStatement.setString(4, producto.getCantidadStock());
            preparedStatement.setString(5, producto.getUrl_img());
            
            int resultado = preparedStatement.executeUpdate();
            if (resultado == 1) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.print("Error al agregar al carrito: " + ex.getMessage());
        }
        
        return respuesta;
    }
    
    public boolean eliminarDelCarrito(Productos producto) {
    boolean respuesta = false;
    
        try {
            String consulta = "DELETE FROM Carrito WHERE Id_Carrito = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
            preparedStatement.setString(1, producto.getId_Producto()); // Supongo que Id_Carrito es el identificador único del producto en el carrito
            int resultado = preparedStatement.executeUpdate();

            if (resultado == 1) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar del carrito: " + ex.getMessage());
        }

        return respuesta;
    }
    
    public void borrarDatosCarrito() {
        try {
            String consulta = "DELETE FROM Carrito";
            manipularDB.executeUpdate(consulta);
        } catch (SQLException ex) {
            System.out.println("Error al borrar datos del carrito: " + ex.getMessage());
        }
    }
    
    public boolean insertarProducto(String nombre,String descripcion, String precio, String cantidad, String img_archivo ){

        boolean respuesta = false;

        try {
            String consulta = "INSERT INTO productos (Nombre, Descripcion, Precio, CantidadStock, Url_img) VALUES('"+nombre+"','"+descripcion+"','"+precio+"','"+cantidad+"','"+img_archivo+"')";
            int resultado = this.manipularDB.executeUpdate(consulta);
            if (resultado==1){
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.print("Error al insertar: " + ex.getMessage());
        }

        return respuesta;
    }

}
