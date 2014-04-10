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
        if(siirtoLaudalla(alkuX, alkuY, kohdeX, kohdeY)==true) {
            if(alkuX != kohdeX || alkuY != kohdeY) {
                if (Math.abs(kohdeX - alkuX) == Math.abs(kohdeY - alkuY) || kohdeX == alkuX || kohdeY == alkuY) {
                    return true;
                }
            }
        }
        return false;
    }
    

}
