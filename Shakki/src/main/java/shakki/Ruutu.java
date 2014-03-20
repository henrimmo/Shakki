/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shakki;

/**
 *
 * @author henrimmo
 */
public class Ruutu {
    
    private final int pysty;
    private final int vaaka;
    
    public Ruutu(int vaaka, int pysty) {
      this.pysty = pysty;
      this.vaaka = vaaka;
    }
    
    public int getPysty() {
        return pysty;
    }
    
    public int getVaaka() {
        return vaaka;
    }
    
    public boolean onkoRuudunSijaintiSallittu() {
        if (vaaka >= 0 && vaaka < 8 && pysty >= 0 && pysty < 8) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return vaaka + "," + pysty;
    }
}