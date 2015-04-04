package gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Jesus
 */
public class PanelCampo extends JPanel{
    
    private final int ANCHO = 897, ALTO = 600;  
    private double MARGEN_BASE_TOP = 13, MARGEN_BASE_RIGTH = 47;
    private double MARGEN_TOP, MARGEN_RIGTH;
    private final ImageIcon CAMPO = new ImageIcon(getClass().getResource("/img/campo.jpg"));
    
    public PanelCampo(){
        super();
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
            //System.out.println("Margen rig:" + MARGEN_RIGTH);
        }else{
            MARGEN_RIGTH = MARGEN_BASE_RIGTH;
        }
        
        //Calcular Margene superior
        if(this.getHeight() != ALTO){
            double porcentaje = (this.getHeight() * 100) /ALTO;
            System.out.println("por " + porcentaje);
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
        
        //Dibujar Jugadores
        
        super.paintComponent(g);
    }
    
}
