package logica.conexion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Jesus
 */
public class Server {

    public ServerSocket server;
    public Socket socket;
    public int puerto;
    public BufferedReader in;
    public DataOutputStream out;
    public EventosSocket eventos;

    public Server(EventosSocket e, int puerto) throws IOException {
        this.eventos = e;
        this.puerto = puerto;
        this.server = new ServerSocket(puerto);
    }

    private void iniciar() throws IOException {
        socket = server.accept();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new DataOutputStream(socket.getOutputStream());
        recivirMensajes();
    }
    
    public void recivirMensajes() throws IOException{
        String mensaje;
        
        while(!socket.isClosed()){
            mensaje = in.readLine().trim();
            if (mensaje != null) {
                System.out.println("cliente: " + mensaje);
                eventos.mensajeRecibido(mensaje);
                if (mensaje.equals("adios")) {
                    socket.close();
                }
            }
        }
    }

    public void enviarMensaje(String texto) throws IOException {
        if (socket != null && !socket.isClosed() && texto != null) {
            System.out.println("server: " + texto);
            out.writeUTF(texto + System.getProperty("line.separator"));

            if (texto.equals("adios")) {
                socket.close();
            }
        } else {
            System.out.println("no enviado :( " + texto);
        }
    }
    
    public void activarServidor() throws IOException{
        if(socket == null){
            iniciar();
        }
    }
    
    public void desactivarServidor() throws IOException{
        socket.close();
    }
    
    public static interface EventosSocket{
        public void mensajeRecibido(String mensaje);
    }
}
