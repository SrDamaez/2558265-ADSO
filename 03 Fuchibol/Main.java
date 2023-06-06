import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Jugador regisJugador[] = new Jugador[100];
        Equipo crearEquipo[] = new Equipo[100];
        int opcion, indiceJugador = 0, indiceEquipo = 0;
        do {System.out.println("++------------------------------------------++");
            System.out.println("++            SISTEMA DE FUCHIBOL           ++");
            System.out.println("++------------------------------------------++");
            System.out.println("||    1. Creacion de Jugador                ||");
            System.out.println("||    2. Creacion de Equipo                 ||");
            System.out.println("||    3. Contratar Jugadores                ||");
            System.out.println("||    4. Cambiar Jugador de Equipo          ||");
            System.out.println("||    5. Ver Listado de Equipos de Futbol   ||");
            System.out.println("||    6. Ver detalle de Equipos de Futbol   ||");
            System.out.println("||    7. Registrar Partido                  ||");
            System.out.println("||    8. Ver detalle de Partidos de Futbol  ||");
            System.out.println("||    9. Ver listado de Partidos de Futbol  ||");
            System.out.println("||       realizados en un Estadio           ||");
            System.out.println("||    10. Salir                             ||");
            System.out.println("++------------------------------------------++");
            System.out.println("++------------------------------------------++");
            System.out.print("OPCION: ");
            opcion = input.nextInt();

            if(opcion==1){//creacion de jugador
                System.out.println("++------------------------------------++");
                System.out.println("++----       CREANDO JUGADOR      ----++");
                System.out.println("++------------------------------------++");
                System.out.print("++----> Documento: ");
                int documento = input.nextInt();
                boolean valid = true;
                for (int i=0;i<regisJugador.length;i++){
                    if(regisJugador[i] != null  && regisJugador[i].getDocumento() == documento){
                        valid = false;
                        //System.out.println(valid);
                    }
                }
                if(valid){
                    input.nextLine();
                    System.out.print("------> Nombre: ");
                    String nombre = input.nextLine();
                    System.out.print("------> Apellido: ");
                    String apellido = input.nextLine();
                    System.out.print("------> Edad: ");
                    int edad = input.nextInt();
                    input.nextLine();
                    System.out.print("------> Posicion: ");
                    String posicion = input.nextLine();
                    boolean estado = true;
                    regisJugador[indiceJugador] = new Jugador(nombre, apellido, edad, posicion, documento, estado);
                    indiceJugador++;
                }else{
                    System.out.println("++-------------------------------------------------++");
                    System.out.println("++----     EL DOCUMENTO INGRESADO YA EXISTE    ----++");
                    System.out.println("++-------------------------------------------------++");
                    System.out.println("++---------ENTER PARA CONTINUAR------------++");
                    input.nextLine();
                    String si = input.nextLine();
                }
            }else if(opcion == 2){
                input.nextLine();
                System.out.println("++------------------------------------++");
                System.out.println("++-----       CREANDO EQUIPO    ------++");
                System.out.println("++------------------------------------++");
                System.out.print("++----> Nombre Equipo: ");
                String nombre = input.nextLine();
                boolean validar = true;
                for (int i = 0; i < crearEquipo.length; i++) {
                    if (crearEquipo[i] != null &&  crearEquipo[i].getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                        validar = false;
                    }
                }
                if(validar){
                    crearEquipo[indiceEquipo] = new Equipo(nombre);
                    indiceEquipo++;
                }else{
                    System.out.println("++-------------------------------------------------++");
                        System.out.println("++----     EL EQUIPO YA EXISTE    ----++");
                        System.out.println("++-------------------------------------------------++");
                        System.out.println("++---------ENTER PARA CONTINUAR------------++");
                        input.nextLine();
                }
            }else if(opcion==3){
                Boolean verificar = false;
                input.nextLine();
                System.out.println("++------------------------------------++");
                System.out.println("++----     CONTRATAR JUGADOR     -----++");
                System.out.println("++------------------------------------++");
                System.out.print("----> Escriba el nombre del equipo: ");
                String nombreequipo = input.nextLine();
                for(int i=0; i < crearEquipo.length; i++){
                    if(crearEquipo[i] != null &&  crearEquipo[i].getNombre().toLowerCase().equals(nombreequipo.toLowerCase())){
                        System.out.println("EQUIPO ENCONTRADO\n");
                        crearEquipo[i].agregarJugadores(regisJugador);
                        verificar = true;
                    }
                }
                if(!verificar){
                    System.out.println("\n\n\n\n++------------------------------------++");
                    System.out.println("++----    EQUIPO NO ENCONTRADO   -----++");
                    System.out.println("++------------------------------------++\n\n\n");
                }
            }else if(opcion == 4){
                Boolean verificar1 = false, verificar2 = false;
                input.nextLine();
                System.out.println("++------------------------------------++");
                System.out.println("++---- CAMBIAR JUGADOR DE EQUIPO -----++");
                System.out.println("++------------------------------------++");
                System.out.print("----> Escriba el nombre del equipo: ");
                String nombreequipo = input.nextLine();

                for(int i=0; i < crearEquipo.length; i++){
                    if(crearEquipo[i] != null &&  crearEquipo[i].getNombre().toLowerCase().equals(nombreequipo.toLowerCase())){
                        System.out.println("EQUIPO ENCONTRADO\nLISTA DE JUGADORES: ");
                        crearEquipo[i].mostrarJugadores();
                        System.out.println("---->Documento del jugador a cambiar: ");
                        int documento = input.nextInt();
                        verificar1=true;

                        if(verificar1){
                            input.nextLine();
                            System.out.print("----> Escriba el nombre del equipo: ");
                            String nombreequipo2 = input.nextLine();

                            for(int j=0; j< crearEquipo.length; j++){
                                if(crearEquipo[j] != null &&  crearEquipo[j].getNombre().toLowerCase().equals(nombreequipo2.toLowerCase())){
                                    System.out.println("Equipo encontrado");
                                    //cambio de equipo
                                    crearEquipo[j].jugadoresEquipos[crearEquipo[j].getEncontraLibre()] = crearEquipo[i].jugadoresEquipos[crearEquipo[i].getcambioJugador(documento)];
                                    //valor queda en null
                                    crearEquipo[i].jugadoresEquipos[crearEquipo[i].getcambioJugador(documento)]=null;
                                    verificar2 = true;
                                }
                            }
                        }
                    }
                }
                if(!verificar1 || !verificar2){
                    System.out.println("\n\n\n\n++------------------------------------++");
                    System.out.println("++----    EQUIPO NO ENCONTRADO   -----++");
                    System.out.println("++------------------------------------++\n\n\n");
                }
                

            }else if(opcion == 5){
                for(int i =0; i < crearEquipo.length; i++){
                    if(crearEquipo[i] != null ){
                        System.out.println("Equipo "+(i+1)+" : "+crearEquipo[i].getNombre());
                    }
                }
            }else if(opcion==6){
                for(int i =0; i < crearEquipo.length; i++){
                    if(crearEquipo[i] != null ){
                        System.out.print("Equipo "+(i+1)+" : "+crearEquipo[i].getNombre()+"\n");
                        crearEquipo[i].mostrarJugadores();
                    }
                }
                System.out.print("\n\n\n");
            }else if(opcion == 7){
                
            }
            
        } while (opcion !=9);
    }
}
