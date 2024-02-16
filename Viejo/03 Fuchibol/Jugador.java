public class Jugador{
    int documento;
    String nombre;
    String apellido;
    int edad;
    String posicion;
    boolean estado;

    public Jugador(String nombre, String apellido, int edad, String posicion,  int documento, boolean estado){
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.posicion = posicion;
        this.estado = estado;
    }

    //setters
    public void setEstado(boolean estado){
        this.estado = estado;
    }

    public void setDocumento(int documento){
        this.documento = documento;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setPosicion(String posicion){
        this.posicion = posicion;
    }

    //getter
    public boolean getEstado(){
        return estado;
    }

    public int getDocumento(){
        return documento;
    }

    public int getEdad(){
        return edad;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getPosicion(){
        return posicion;
    }

    public String imprimirDatos(){
        return documento+"  "+edad+"  "+nombre+"   "+apellido+"   "+posicion;
    }
}