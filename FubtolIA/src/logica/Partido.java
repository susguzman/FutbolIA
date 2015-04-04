package logica;

import java.util.LinkedList;

/**
 *
 * @author Jesus
 */
public class Partido {
    
    public static final int PRIMERO = 0, SEGUNDO = 1;    
    private boolean jugando;
    private int tiempo;
    public LinkedList<Jugador> jugadoresA, jugadoresB;
    
    public Partido(){
        //Inicializar
        jugadoresA = new LinkedList<>();
        jugadoresB = new LinkedList<>();
        jugando = false; 
        
        //Crear juagares a
        jugadoresA.add(new Jugador(Jugador.PORTERO, 0, 5));
        jugadoresA.add(new Jugador(Jugador.DEFENSA, 3, 3));
        jugadoresA.add(new Jugador(Jugador.DEFENSA, 3, 7));
        jugadoresA.add(new Jugador(Jugador.DELANTERO, 8, 4));
        jugadoresA.add(new Jugador(Jugador.DELANTERO, 8, 6));
        
        //Crear juagares a
        jugadoresB.add(new Jugador(Jugador.PORTERO, 16, 5));
        jugadoresB.add(new Jugador(Jugador.DEFENSA, 13, 2));
        jugadoresB.add(new Jugador(Jugador.DEFENSA, 13, 8));
        jugadoresB.add(new Jugador(Jugador.DELANTERO, 8, 3));
        jugadoresB.add(new Jugador(Jugador.DELANTERO, 8, 7));
    }
    
    public void iniciar(){
        
    }
}
