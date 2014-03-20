/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shakki;

import Nappula.Nappula;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author henrimmo
 */
public class Lauta {
    
    
    private final Map<Ruutu, Nappula> sijainnit;
    
    public Lauta() {
        this.sijainnit = new HashMap<Ruutu, Nappula>();
    }
    
    public void asetaNappula(Ruutu ruutu, Nappula nappula) {
        if (ruutu != null && nappula != null) {
            sijainnit.put(ruutu, nappula);
        }
    }

    
    public boolean onkoRuutuVapaa(Ruutu kohde) {
        boolean apu = true;
        for (Ruutu ruutu : sijainnit.keySet()) {
           if (sijainnit.get(ruutu).getX() == kohde.getVaaka() && sijainnit.get(ruutu).getY() == kohde.getPysty()) {
               apu = false;
           }
        }
        return apu;
    } 
    
    public void siirry(Ruutu alku, Ruutu kohde) {
        if (alku != null && kohde != null) {
            for (Ruutu ruutu : sijainnit.keySet()) { 
                sijainnit.get(alku).setX(kohde.getVaaka());
                sijainnit.get(alku).setY(kohde.getPysty());
            }
        }
    }
    
    @Override
    public String toString() {
        String ruudut = "";
        String nappulat = "";
        for (Ruutu ruutu : sijainnit.keySet()) {
//            ruudut = ruudut + ruutu.toString();
            nappulat = nappulat + " " + sijainnit.get(ruutu).toString();
        }
        return nappulat;
    }
    
    

}

