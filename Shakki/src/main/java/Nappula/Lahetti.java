/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappula;

/**
 *
 * @author Henri
 */
public class Lahetti extends Nappula{
    
    public Lahetti(int x, int y, boolean vari) {
        super(x, y, vari);
        if (vari) {
            tyyppi = "L";
        } else {
            tyyppi = "l";
        }
    }
    
    public Lahetti(boolean vari) {
        super(vari);
                if (vari) {
            tyyppi = "L";
        } else {
            tyyppi = "l";
        }
    }

    @Override
    public boolean siirra(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
