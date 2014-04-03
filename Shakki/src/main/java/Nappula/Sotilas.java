/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappula;

/**
 *
 * @author Henri
 */
public class Sotilas extends Nappula{
    
    public Sotilas(int x, int y, boolean vari) {
        super(x, y, vari);
        if (vari) {
            tyyppi = "S";
        } else {
            tyyppi = "s";
        }
    }
    
    public Sotilas(boolean vari) {
        super(vari);
                if (vari = true) {
            tyyppi = "S";
        } else {
            tyyppi = "s";
        }
    }

    @Override
    public boolean siirra(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
}
