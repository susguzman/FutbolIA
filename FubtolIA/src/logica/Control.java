package logica;

import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpl.Query;
import logica.conexion.Server;

/**
 *
 * @author Jesus
 */
public class Control implements Server.EventosSocket {

    public static final int CONTRA_IA = 0, CONTRA_OTRO = 1;
    public int tipo_juego, minutos, segundos, goles_a, goles_b, pos_x_b, pos_y_b, n_parte;
    public boolean multiplayer, jugando, espera;
    public Server servidor;
    public int puerto_servidor, puerto_cliente;
    public String ip_cliente, equipo_a, equipo_b, parte, turno;
    public EventosControl eventos;
    public LinkedList<Jugador> jugadoresA, jugadoresB;
    public Query consultador;

    public Control(EventosControl e) {
        this.eventos = e;
        this.multiplayer = false;
        this.jugando = false;
        this.jugadoresA = new LinkedList<>();
        this.jugadoresB = new LinkedList<>();
    }

    public void startIA() {
        this.tipo_juego = CONTRA_IA;
        this.jugando = true;
        this.espera = false;
        this.equipo_a = "Yo";
        this.equipo_b = "IA";
        this.goles_a = this.goles_b = 0;
        this.parte = "UNO";
        this.n_parte = 1;
        this.turno = "a";

        consultador = new Query("consult('logica.pl')");
        consultador.hasSolution();
        
        crearJugadores();
        setPosIniciales(1);
        setParte(1);
        startCronometro();
        eventos.actualizarUI();
        iniciarLogicaIA();
    }

    public void stopIA() {
        this.jugando = false;
        this.espera = false;
    }

    private void startCronometro() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (jugando) {
                    if (!espera) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        if (segundos < 59) {
                            segundos++;
                        } else {
                            segundos = 0;
                            minutos++;
                        }

                        if (minutos == 4) {
                            cambioTurno();
                        }

                        eventos.cambiarTiempo();
                    }
                }

                segundos = minutos = 0;
            }
        }).start();
    }

    private void crearJugadores() {
        jugadoresA = new LinkedList<>();
        jugadoresB = new LinkedList<>();

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

    private void setPosIniciales(int tiempo) {
        if (tiempo == 1) {
            jugadoresA.get(0).setPos(0, 5);
            jugadoresA.get(1).setPos(3, 3);
            jugadoresA.get(2).setPos(3, 8);
            jugadoresA.get(3).setPos(8, 1);
            jugadoresA.get(4).setPos(8, 6);

            jugadoresB.get(0).setPos(16, 5);
            jugadoresB.get(1).setPos(13, 3);
            jugadoresB.get(2).setPos(13, 8);
            jugadoresB.get(3).setPos(8, 3);
            jugadoresB.get(4).setPos(8, 9);

        } else {
            jugadoresB.get(0).setPos(0, 5);
            jugadoresB.get(1).setPos(3, 3);
            jugadoresB.get(2).setPos(3, 8);
            jugadoresB.get(3).setPos(8, 1);
            jugadoresB.get(4).setPos(8, 6);

            jugadoresA.get(0).setPos(16, 5);
            jugadoresA.get(1).setPos(13, 3);
            jugadoresA.get(2).setPos(13, 8);
            jugadoresA.get(3).setPos(8, 3);
            jugadoresA.get(4).setPos(8, 9);

        }
        pos_x_b = 8;
        pos_y_b = 5;

        setJugadorLogica("a", "por", "0", "5");
        setJugadorLogica("a", "def1", "3", "3");
        setJugadorLogica("a", "def2", "3", "8");
        setJugadorLogica("a", "del1", "8", "1");
        setJugadorLogica("a", "del2", "8", "6");

        setJugadorLogica("b", "por", "16", "5");
        setJugadorLogica("b", "def1", "13", "3");
        setJugadorLogica("b", "def2", "13", "8");
        setJugadorLogica("b", "del1", "8", "3");
        setJugadorLogica("b", "del2", "8", "9");

        setBalonLogica("8", "5");
    }

    private void setJugadorLogica(String equipo, String jugador, String X, String Y) {
        //consultador = new Query("consult('logica.pl')");
        //if (consultador.hasSolution()) {
        String t1 = "set_pos_jugador(" + equipo + "," + jugador + "," + X + "," + Y + ").";
        Query query = new Query(t1);
        query.hasSolution();
        //}
    }

    private void setBalonLogica(String X, String Y) {
        //Query consultador = new Query("consult('logica.pl')");
        //if (consultador.hasSolution()) {
        String t1 = "set_pos_balon(" + X + "," + Y + ").";
        Query query = new Query(t1);
        query.hasSolution();
        //}
    }

    private void setNuevoTurno() {
        //Query consultador = new Query("consult('logica.pl')");
        //if (consultador.hasSolution()) {
        String t1 = "set_mov_turno(0).";
        Query query = new Query(t1);
        query.hasSolution();
        //}
    }

    private void setParte(int p) {
        //Query consultador = new Query("consult('logica.pl')");
        //if (consultador.hasSolution()) {
        String t1 = "set_parte(" + p + ").";
        Query query = new Query(t1);
        query.hasSolution();
        //}
    }

    private void getPosicionJugador(int pos, String equipo, String jugador) {
        //Query consultador = new Query("consult('logica.pl')");
        //if (consultador.hasSolution()) {
        String query = "pos_jugador(" + equipo + "," + jugador + ",X,Y).";
        Query query1 = new Query(query);
        Hashtable[] ss = query1.allSolutions();
        String x = "0", y = "0";
        for (Hashtable s : ss) {
            if (s.containsKey("X")) {
                x = s.get("X").toString();
            }

            if (s.containsKey("Y")) {
                y = s.get("Y").toString();
            }
        }

        //System.out.println("Equipo: " + equipo + " j:" + jugador + " x:" + x + " y:" + y);
        if (n_parte == 1) {
            if (equipo.equals("a")) {
                Jugador j = jugadoresA.get(pos);
                j.setPos(Integer.parseInt(x), Integer.parseInt(y));
            } else {
                jugadoresB.get(pos).setPos(Integer.parseInt(x), Integer.parseInt(y));
            }
        } else {
            if (equipo.equals("a")) {
                jugadoresB.get(pos).setPos(Integer.parseInt(x), Integer.parseInt(y));
            } else {
                jugadoresA.get(pos).setPos(Integer.parseInt(x), Integer.parseInt(y));
            }
        }

        //}
    }

    private void getPosicionBalon() {
        //Query consultador = new Query("consult('logica.pl')");
        //if (consultador.hasSolution()) {
        String query = "pos_balon(X,Y).";
        Query query1 = new Query(query);
        Hashtable[] ss = query1.allSolutions();
        String x = "0", y = "0";
        for (Hashtable s : ss) {
            if (s.containsKey("X")) {
                x = s.get("X").toString();
            }

            if (s.containsKey("Y")) {
                y = s.get("Y").toString();
            }
        }

        pos_x_b = Integer.parseInt(x);
        pos_y_b = Integer.parseInt(y);
        //System.out.println("Balon x:" + x + " y:" + y);
        //}
    }

    private void getPosiciones() {
        getPosicionJugador(0, turno, "por");
        getPosicionJugador(1, turno, "def1");
        getPosicionJugador(2, turno, "def2");
        getPosicionJugador(3, turno, "del1");
        getPosicionJugador(4, turno, "del2");
        getPosicionBalon();
    }
    
    private void getMarcador(){
        String query = "marcador(X,Y).";
        Query query1 = new Query(query);
        Hashtable[] ss = query1.allSolutions();
        String x = "0", y = "0";
        for (Hashtable s : ss) {
            if (s.containsKey("X")) {
                x = s.get("X").toString();
            }

            if (s.containsKey("Y")) {
                y = s.get("Y").toString();
            }
        }

        goles_a = Integer.parseInt(x);
        goles_b = Integer.parseInt(y);
    }

    private void cambioTurno() {
        if (n_parte == 1) {
            this.espera = true;
            this.parte = "DOS";
            this.n_parte = 2;
            this.turno = "b";
            this.minutos = 0;
            this.segundos = 0;

            setPosIniciales(2);
            setParte(2);
            eventos.setEstadisticas();
            eventos.actualizarUI();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.espera = false;
        } else {
            this.jugando = false;
        }

    }

    private void iniciarLogicaIA() {
        boolean es_turno;
        while (jugando) {
            if (!espera) {
                setNuevoTurno();

                do {
                    String t1 = "turno(" + turno + ").";
                    Query query = new Query(t1);
                    query.hasSolution();

                    //actualizar grafica
                    getPosiciones();
                    getMarcador();
                    eventos.cambiarMarcador();
                    eventos.actualizarUI();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    String t2 = "es_turno.";
                    Query query2 = new Query(t2);
                    es_turno = query2.hasSolution();
                    
                } while (es_turno);

                if (turno.equals("a")) {
                    turno = "b";
                } else {
                    turno = "a";
                }
                //System.out.println("Cambio Turno: " + turno);
            }
        }
        
        eventos.terminarPartido();
    }

    public void setDatosConexion(String ip_cliente, int puerto_cliente, int puerto_servidor) {
        this.ip_cliente = ip_cliente;
        this.puerto_cliente = puerto_cliente;
        this.puerto_servidor = puerto_servidor;
    }

    public void activarMultiplayer() throws IOException {
        servidor = new Server(this, puerto_servidor);
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    servidor.activarServidor();
                } catch (IOException ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();

        multiplayer = true;
    }

    public void desactivarMultiplayer() throws IOException {
        if (servidor != null) {
            servidor.desactivarServidor();
        }
        this.multiplayer = false;
    }

    @Override
    public void mensajeRecibido(String mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static interface EventosControl {

        public void cambiarTiempo();

        public void setEstadisticas();
        
        public void cambiarMarcador();

        public void actualizarUI();
        
        public void terminarPartido();
    }

}
