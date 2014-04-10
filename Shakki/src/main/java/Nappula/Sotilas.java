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
    
    private boolean ekaSiirto;
    
    public Sotilas(int x, int y, boolean vari) {
        super(x, y, vari);
        if (vari) {
            tyyppi = "S";
        } else {
            tyyppi = "s";
        }
        ekaSiirto = true;
    }
    
    public Sotilas(boolean vari) {
        super(vari);
                if (vari) {
            tyyppi = "S";
        } else {
            tyyppi = "s";
        }
        ekaSiirto = true;        
    }

    @Override
    public boolean siirra(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        if(siirtoLaudalla(alkuX, alkuY, kohdeX, kohdeY)==true) {
            if(alkuX != kohdeX || alkuY != kohdeY) {
                if (this.getVari() == true) {
                    if(ekaSiirto == true) {
                        if(kohdeY - alkuY == 2 || kohdeY - alkuY == 1) {
                            ekaSiirto = false;
                            return true;
                        }
                    }
                    if (kohdeY - alkuY == 1) {
                        return true;
                    }
                } 
                if(this.getVari()==false){
                    if(ekaSiirto == true) {
                        if(kohdeY - alkuY == -2 || kohdeY - alkuY == -1) {
                            ekaSiirto = false;
                            return true;
                        }
                    }
                    if(kohdeY - alkuY == -1) {
                        return true;
                    }
                } 
            }
        }
        return false;
    }
}
