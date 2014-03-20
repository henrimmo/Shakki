/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nappula;


/**
 *
 * @author henrimmo
 */
public class Nappula {
    
    private int x;
    private int y;
    private Tyyppi tyyppi;
    private Vari vari;
    
    
    
    public Nappula(int x, int y, Tyyppi tyyppi, Vari vari) {
        this.x = x;
        this.y = y;
        this.tyyppi = tyyppi;
        this.vari = vari;
        
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
    
    public Tyyppi getTyyppi() {
        return tyyppi;
    }
    
    public Vari getVari() {
        return vari;
    }
    
    @Override
    public String toString() {
        return vari.name() + " " + tyyppi.name() + ", sijainti: " + x + "," + y; 
    }
    
}
