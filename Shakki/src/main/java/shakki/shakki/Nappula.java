/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shakki.shakki;

/**
 *
 * @author henrimmo
 */
public class Nappula {
    
    private int x;
    private int y;
    private Tyyppi tyyppi;
    private Vari väri;
    
    
    
    public Nappula(int x, int y, Tyyppi tyypi, Vari väri) {
        this.x = x;
        this.y = y;
        this.tyyppi = tyyppi;
        
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
}
