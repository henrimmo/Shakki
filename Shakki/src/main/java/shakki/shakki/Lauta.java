/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shakki.shakki;

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
    

}

