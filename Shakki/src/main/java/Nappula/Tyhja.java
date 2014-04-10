/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappula;

/**
 *
 * @author Henri
 */
public class Tyhja extends Nappula{
    
    public Tyhja(int x, int y, boolean vari) {
        super(x, y, vari);
        tyyppi = "";
    }
    
    public Tyhja(boolean vari) {
        super(vari);
        tyyppi = "";
        
    }

    @Override
    public boolean siirra(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
