/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappula;

/**
 *
 * @author Henri
 */
public class Ratsu extends Nappula{
    
    public Ratsu(int x, int y, boolean vari) {
        super(x, y, vari);
        if (vari) {
            tyyppi = "R";
        } else {
            tyyppi = "r";
        }
    }
    
    public Ratsu(boolean vari) {
        super(vari);
                if (vari) {
            tyyppi = "R";
        } else {
            tyyppi = "r";
        }
    }

    @Override
    public boolean siirra(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
