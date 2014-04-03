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
    
    public Nappula[][] nappulaSijainnit;

    
    public Lauta() {
        nappulaSijainnit = new Nappula[8][8];
    }
    
    public Nappula asetaNappula(Nappula nappula, int x, int y) {
        nappulaSijainnit[x][y] = nappula;
        nappula.x = x;
        nappula.y = y;
        return nappula;
    }
    
        public boolean siirraNappula(int alkuX, int alkuY, int kohdeX, int kohdeY) {
             nappulaSijainnit[kohdeX][kohdeY] = nappulaSijainnit[alkuX][alkuY];
             nappulaSijainnit[alkuX][alkuY] = null;
             return true;
    }
    


    
    

}

