import java.util.*;

public class Equipo {
    String nombre;
    JugadorEquipo jugadoresEquipos[];
    Scanner input = new Scanner(System.in);

    public Equipo(String nombre) {
        this.nombre = nombre;
        JugadorEquipo temporal[] = new JugadorEquipo[20];
        jugadoresEquipos = temporal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarJugadores(Jugador[] regisJugador) {
        int indice=0;
        for(int j=0; j<jugadoresEquipos.length;j++){
            if(jugadoresEquipos[j]==null){
                indice=j;
                break;
            }
        }
        int opcion = 0, auxequipo=indice;
        do {
            System.out.println("++-------------------------------------++");
            System.out.println("++---- LISTA JUGADORES DISPONIBLES ----++");
            System.out.println("++-------------------------------------++");
            boolean jugadoresdato = false;
            for (int i = 0; i < regisJugador.length; i++) {
                if (regisJugador[i] != null && regisJugador[i].estado) {
                    System.out.println(regisJugador[i].imprimirDatos());
                    jugadoresdato = true;
                }
            }
            // opcion = input.nextInt();
            if (jugadoresdato) {
                System.out.println("\nINGRESE EL DOCUMENTO DEL JUGADOR QUE QUIERE COMPRAR: ");
                int documento = input.nextInt();
                for (int i = 0; i < regisJugador.length; i++) {
                    if (regisJugador[i] != null && regisJugador[i].getDocumento() == documento) {
                        System.out.print("\nASIGNAR DORSAL: ");
                        int dorsal = input.nextInt();
                        JugadorEquipo jugadorequipo = new JugadorEquipo(regisJugador[i], dorsal);
                        jugadoresEquipos[auxequipo] = jugadorequipo;
                        auxequipo++;
                        regisJugador[i].estado = false;
                        System.out.println("Contratado");
                        break;
                    }
                }
                System.out.print("[2 AGREGAR JUGADOR] [1 PARA SALIR] ");
                System.out.println(auxequipo);
                opcion = input.nextInt();
            }else{
                System.out.println("\n\n\n++-------------------------------------++");
                System.out.println("++-----  JUGADORES NO DISPONIBLES -----++");
                System.out.println("++-------------------------------------++\n\n\n");
                break;
            }
            

        } while (opcion != 1);
        
    }

    public void mostrarJugadores(){
        for (int i = 0; i < jugadoresEquipos.length; i++) {
            if (jugadoresEquipos[i] != null) {
                System.out.println(jugadoresEquipos[i].mostrarJugador());
            }
        }
    }

    public int getcambioJugador(int documentox){
        int indicecambio=0;
        for (int i = 0; i < jugadoresEquipos.length; i++) {
            if (jugadoresEquipos[i] != null && jugadoresEquipos[i].getJugador().documento==documentox) {
                indicecambio = i;
                //System.out.println(indicecambio);
                break;
            }
        }
        return indicecambio;
    }

    public int getEncontraLibre(){
        int indice=0;
        for(int j=0; j<jugadoresEquipos.length;j++){
            if(jugadoresEquipos[j]==null){
                indice=j;
                break;
            }
        }
        return indice;
    }

    
}
