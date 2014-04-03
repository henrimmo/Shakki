/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappula;

/**
 *
 * @author Henri
 */
public class Kuningatar extends Nappula{
    
    public Kuningatar(int x, int y, boolean vari) {
        super(x, y, vari);
        if (vari) {
            tyyppi = "Q";
        } else {
            tyyppi = "q";
        }
    }
    
    public Kuningatar(boolean vari) {
        super(vari);
                if (vari) {
            tyyppi = "Q";
        } else {
            tyyppi = "q";
        }
    }

    @Override
    public boolean siirra(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
