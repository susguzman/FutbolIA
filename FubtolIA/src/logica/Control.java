package logica;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.conexion.Server;

/**
 *
 * @author Jesus
 */
public class Control implements Server.EventosSocket {

    public static final int CONTRA_IA = 0, CONTRA_OTRO = 1, EQUIPO_A = 0, EQUIPO_B = 1;
    public int tipo_juego;
    public boolean enable_multiplayer;
    public Server servidor;
    public int puerto_servidor, puerto_cliente;
    public String ip_cliente;
    public Partido partido;
    public EventosControl eventos;

    public Control(EventosControl e) {
        this.eventos = e;
        this.partido = new Partido();
    }

    public void iniciar(int tipo) {
        this.tipo_juego = tipo;
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
        
        enable_multiplayer = true;
    }

    public void desactivarMultiplayer() throws IOException {
        if (servidor != null) {
            servidor.desactivarServidor();
        }
        this.enable_multiplayer = false;
    }

    @Override
    public void mensajeRecibido(String mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static interface EventosControl{
        public void cambiarTiempo();
        public void cambiarMarcador();
        public void actualizarUI();
    }

}
