/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappula;

/**
 *
 * @author Henri
 */
public class Kuningas extends Nappula{
    
    public Kuningas(int x, int y, boolean vari) {
        super(x, y, vari);
        if (vari) {
            tyyppi = "K";
        } else {
            tyyppi = "k";
        }
    }
    
    public Kuningas(boolean vari) {
        super(vari);
                if (vari) {
            tyyppi = "K";
        } else {
            tyyppi = "k";
        }
    }

    @Override
    public boolean siirra(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
