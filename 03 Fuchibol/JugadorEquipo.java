public class JugadorEquipo {
    Jugador jugador;
    int dorsal;

    public JugadorEquipo( Jugador jugador,  int dorsal){
        this.jugador = jugador;
        this.dorsal = dorsal;
    }

    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }

    public void setDorsal(int dorsal){
        this.dorsal = dorsal;
    }

    public Jugador getJugador(){
        return jugador;
    }

    public int getDorsal(){
        return dorsal;
    }

    public String mostrarJugador(){
        return jugador.imprimirDatos()+"     "+dorsal;
    }
}
