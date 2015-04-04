package logica;

/**
 *
 * @author Jesus
 */
public class Jugador {
    
    public static final int PORTERO = 0, DEFENSA = 1, DELANTERO = 2;
        
    //private final Partido partido;
    private int rol;
    private int posX;
    private int posY;
    
    public Jugador(int rol){
        this(rol, 0, 0);
    }
    
    public Jugador(int rol, int x, int y){
        this.rol = rol;
        this.posX = x;
        this.posY = y;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        setPos(posX, posY);
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        setPos(posX, posY);
    }
    
    public void setPos(int x, int y){
        this.posX = x;
        this.posY = y;
    }
    
}
