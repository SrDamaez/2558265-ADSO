package clases;

public class Productos {
    
    String id_Producto;
    String Nombre;
    String Descripcion;
    String Precio;
    String CantidadStock;
    String Url_img;

    public Productos(String id_Producto, String Nombre, String Descripcion, String Precio, String CantidadStock, String Url_img) {
        this.id_Producto = id_Producto;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.CantidadStock = CantidadStock;
        this.Url_img = Url_img;
    }

    public String getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(String id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getCantidadStock() {
        return CantidadStock;
    }

    public void setCantidadStock(String CantidadStock) {
        this.CantidadStock = CantidadStock;
    }

    public String getUrl_img() {
        return Url_img;
    }

    public void setUrl_img(String Url_img) {
        this.Url_img = Url_img;
    }
    
    
    
}
