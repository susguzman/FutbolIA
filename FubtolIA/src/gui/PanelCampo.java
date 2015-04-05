package gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import logica.Control;
import logica.Jugador;

/**
 *
 * @author Jesus
 */
public class PanelCampo extends JPanel{
    
    private final int ANCHO = 897, ALTO = 600;  
    private double MARGEN_BASE_TOP = 13, MARGEN_BASE_RIGTH = 47;
    private double MARGEN_TOP, MARGEN_RIGTH;
    private Control control;
    private final ImageIcon CAMPO = new ImageIcon(getClass().getResource("/img/campo.jpg"));
    private final ImageIcon R_PORTERO = new ImageIcon(getClass().getResource("/img/r_portero.png"));
    private final ImageIcon R_DEFENSA = new ImageIcon(getClass().getResource("/img/r_defensa.png"));
    private final ImageIcon R_DELANTERO = new ImageIcon(getClass().getResource("/img/r_delantero.png"));
    private final ImageIcon A_PORTERO = new ImageIcon(getClass().getResource("/img/a_portero.png"));
    private final ImageIcon A_DEFENSA = new ImageIcon(getClass().getResource("/img/a_defensa.png"));
    private final ImageIcon A_DELANTERO = new ImageIcon(getClass().getResource("/img/a_delantero.png"));
    
    public PanelCampo(Control c){
        super();        
        this.control = c;
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        //Calcular Margene lados
        if(this.getWidth() != ANCHO){
            double porcentaje = (this.getWidth() * 100) /ANCHO;
            if(porcentaje > 100){
                MARGEN_RIGTH = MARGEN_BASE_RIGTH + ((MARGEN_BASE_RIGTH * (porcentaje - 100))/100);
            }else if(porcentaje < 100){
                MARGEN_RIGTH = MARGEN_BASE_RIGTH - ((MARGEN_BASE_RIGTH * (100 - porcentaje))/100);
            }else{
                MARGEN_RIGTH = MARGEN_BASE_RIGTH;
            }
        }else{
            MARGEN_RIGTH = MARGEN_BASE_RIGTH;
        }
        
        //Calcular Margene superior
        if(this.getHeight() != ALTO){
            double porcentaje = (this.getHeight() * 100) /ALTO;
            if(porcentaje > 100){
                MARGEN_TOP = MARGEN_BASE_TOP + ((MARGEN_BASE_TOP * (porcentaje - 100))/100);
            }else if(porcentaje < 100){
                MARGEN_TOP = MARGEN_BASE_TOP - ((MARGEN_BASE_TOP * (100 - porcentaje))/100);
            }else{
                MARGEN_TOP = MARGEN_BASE_TOP;
            }
        }else{
            MARGEN_TOP = MARGEN_BASE_TOP;
        }
        
        //Dibujar campo
        g.drawImage(CAMPO.getImage(), 0, 0, super.getWidth(), super.getHeight(), this);
        
        double ancho = (this.getWidth() - MARGEN_RIGTH * 2) / 17;
        double alto = (this.getHeight() - MARGEN_TOP * 2) / 11;
        
        //Dibujar lineas verticales 17       
        g2d.setStroke(new BasicStroke(2f));
        
        for (int i = 0; i < 18; i++) {
            g2d.drawLine((int)(i * ancho) + (int)MARGEN_RIGTH, (int)MARGEN_TOP, (int)(i * ancho) + (int)MARGEN_RIGTH, this.getHeight() - (int)MARGEN_TOP);            
        }
        
        //Dibujar lineas horizonatal 11
        for (int i = 0; i < 13; i++) {
            g2d.drawLine((int)MARGEN_RIGTH, (i * (int)alto) + (int)MARGEN_TOP, this.getWidth() - (int)MARGEN_RIGTH, (i * (int)alto) + (int)MARGEN_TOP);            
        }
        
        //Dibujar Jugadores A
        for(Jugador j : control.partido.jugadoresA){
            if(j.getRol() == Jugador.PORTERO){
                g.drawImage(R_PORTERO.getImage(), (int)getPosXJugador(j, ancho), (int)getPosYJugador(j, alto), (int)ancho, (int)alto, this);
            }else if(j.getRol() == Jugador.DEFENSA){
                g.drawImage(R_DEFENSA.getImage(), (int)getPosXJugador(j, ancho), (int)getPosYJugador(j, alto), (int)ancho, (int)alto, this);
            }else{
                g.drawImage(R_DELANTERO.getImage(), (int)getPosXJugador(j, ancho), (int)getPosYJugador(j, alto), (int)ancho, (int)alto, this);
            }            
        }
        
        //Dibujar Jugadores B
        for(Jugador j : control.partido.jugadoresB){
            if(j.getRol() == Jugador.PORTERO){
                g.drawImage(A_PORTERO.getImage(), (int)getPosXJugador(j, ancho), (int)getPosYJugador(j, alto), (int)ancho, (int)alto, this);
            }else if(j.getRol() == Jugador.DEFENSA){
                g.drawImage(A_DEFENSA.getImage(), (int)getPosXJugador(j, ancho), (int)getPosYJugador(j, alto), (int)ancho, (int)alto, this);
            }else{
                g.drawImage(A_DELANTERO.getImage(), (int)getPosXJugador(j, ancho), (int)getPosYJugador(j, alto), (int)ancho, (int)alto, this);
            }
        }
        
        
        super.paintComponent(g);
    }
    
    private double getPosXJugador(Jugador j, double ancho){
        return (j.getPosX() * ancho) + MARGEN_RIGTH;
    }
    
    private double getPosYJugador(Jugador j, double alto){
        return (j.getPosY() * alto) + MARGEN_TOP;
    }
    
}
