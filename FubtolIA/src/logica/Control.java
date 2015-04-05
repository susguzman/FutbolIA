package logica;

import java.io.IOException;
import logica.conexion.Server;

/**
 *
 * @author Jesus
 */
public class Control implements Server.EventosSocket{

    public static final int CONTRA_IA = 0, CONTRA_OTRO = 1, EQUIPO_A = 0, EQUIPO_B = 1;
    public int tipo_juego;
    public boolean enable_multiplayer;
    public Server servidor;
    public int puerto_servidor, puerto_cliente;
    public String ip_cliente;
    
    public Control(){
    }
    
    public Control(String ip_cliente, int puerto_cliente, int puerto_servidor) throws IOException{        
        activarMultiplayer(ip_cliente, puerto_cliente, puerto_servidor);
    }
    
    public void iniciar(int tipo){
        this.tipo_juego = tipo;
    }
    
    public void activarMultiplayer(String ip_cliente, int puerto_cliente, int puerto_servidor) throws IOException{
        if(servidor == null){
            servidor = new Server(this);
            servidor.activarServidor();
            enable_multiplayer = true;
            this.ip_cliente = ip_cliente;
            this.puerto_cliente = puerto_cliente;
            this.puerto_servidor = puerto_servidor;
        }
    }
    
    public void desactivarMultiplayer() throws IOException{
        if(servidor != null){
            servidor.desactivarServidor();
            enable_multiplayer = false;
        }
    }

    @Override
    public void mensajeRecibido(String mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
