public class Main {
    public static void main(String[] args) {

        System.out.println();
        //creacion de datos
        Persona clientes[] = new Persona[5];
        clientes[0] = (new Persona(108800, "Juan Pérez", "Calle 10 #15-20"));
        clientes[1] = (new Persona(108801, "Ana Sánchez", "Carrera 5 #23-11"));
        clientes[2] = (new Persona(108802, " Luisa Fernanda García", "Avenida Circunvalar #40-30"));
        clientes[3] = (new Persona(108803, "Ricardo Gómez", "Calle 25 #6-45"));
        clientes[4] = (new Persona(108804, "Mariana Valencia", "Carrera 8 #31-18"));

        //vendedor
        Persona vendedor[] = new Persona[5];
        vendedor[0] = (new Persona(109900, "Ana Duque", "Carrera 7 #15-25"));
        vendedor[1] = (new Persona(109901, "Carlos Gómez", "Carrera 9 #19-32"));
        vendedor[2] = (new Persona(109902, "María López", "Calle 12 #21-15"));
        vendedor[3] = (new Persona(109903, "Andrés Ramírez", "Avenida Bolívar #28-10"));
        vendedor[4] = (new Persona(109904, "Laura Osorio", "Calle 16 #30-12"));

        //productos
        Productos productos[] = new Productos[5];
        productos[0] = (new Productos(1010, "Leche", 20));
        productos[1] = (new Productos(1011, "Carne 1Kg", 11));
        productos[2] = (new Productos(1012, "Carne 1Lb", 10));
        productos[3] = (new Productos(1013, "Jabon Barra", 20));
        productos[4] = (new Productos(1014, "Detengente 1Kg", 20));

        


        Factura factura = new Factura(clientes, vendedor, productos);
    }
}