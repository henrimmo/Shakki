/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappula;

/**
 *
 * @author Henri
 */
public class Torni extends Nappula{
    
    
    public Torni(int x, int y, boolean vari) {
        super(x, y, vari);
        if (vari = true) {
            tyyppi = "T";
        } else {
            tyyppi = "t";
        }
    }
    
    public Torni(boolean vari){
        super(vari);
                if (vari) {
            tyyppi = "T";
        } else {
            tyyppi = "t";
        }
    }    

    @Override
    public boolean siirra(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        if(siirtoLaudalla(alkuX, alkuY, kohdeX, kohdeY)==true) {
            if(alkuX != kohdeX || alkuY != kohdeY) {
                if (alkuX - kohdeX == 0 || alkuY - kohdeY == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    
}
