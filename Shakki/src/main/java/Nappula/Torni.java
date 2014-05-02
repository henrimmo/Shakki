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
    
    public boolean ekaSiirto;
    
    public Torni(int x, int y, boolean vari) {
        super(x, y, vari);
        if (vari) {
            tyyppi = "T";
        } else {
            tyyppi = "t";
        }
        ekaSiirto = true;
    }
    
    public Torni(boolean vari){
        super(vari);
                if (vari) {
            tyyppi = "T";
        } else {
            tyyppi = "t";
        }
        ekaSiirto = true;
    }    

    @Override
    public boolean siirra(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        if(siirtoLaudalla(alkuX, alkuY, kohdeX, kohdeY)==true) {
            if(alkuX != kohdeX || alkuY != kohdeY) {
                if (alkuX == kohdeX || alkuY == kohdeY) {
                    ekaSiirto = false;
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
        public boolean getEkaSiirto() {
        return ekaSiirto;
    }

    
}
