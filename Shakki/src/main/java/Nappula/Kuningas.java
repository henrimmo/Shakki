/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappula;


public class Kuningas extends Nappula{
    
    public boolean ekaSiirto;
    
    public Kuningas(int x, int y, boolean vari) {
        super(x, y, vari);
        if (vari) {
            tyyppi = "K";
        } else {
            tyyppi = "k";
        }
        ekaSiirto = true;
    }
    
    public Kuningas(boolean vari) {
        super(vari);
                if (vari) {
            tyyppi = "K";
        } else {
            tyyppi = "k";
        }
        ekaSiirto = true;
    }


    @Override
    public boolean siirra(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        if(siirtoLaudalla(alkuX, alkuY, kohdeX, kohdeY)==true) {
            if(alkuX != kohdeX || alkuY != kohdeY) {
                if (Math.abs(kohdeX - alkuX) <= 1 && Math.abs(kohdeY - alkuY) <= 1) {
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
