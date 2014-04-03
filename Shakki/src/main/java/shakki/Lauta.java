/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shakki;

import Nappula.Kuningas;
import Nappula.Kuningatar;
import Nappula.Lahetti;
import Nappula.Nappula;
import Nappula.Ratsu;
import Nappula.Sotilas;
import Nappula.Torni;

/**
 *Sisältää shakkipelin pelimekaniikan ja siirtoihin liittyviä toimintoja
 * @author henrimmo
 */
public class Lauta {
    
    public Nappula[][] nappulat;
    
/*
 * vuoroa kuvaava muuttuja,
 * true = valkoisen vuoro, false = mustan 
 */  
    
    public boolean vuoro;

    
    public Lauta() {
        nappulat = new Nappula[8][8];
    }
    
    
    public Nappula setNappula(Nappula nappula, int x, int y) {
        nappulat[x][y] = nappula;
        nappula.x = x;
        nappula.y = y;
        return nappula;
    }
    
/**
 * asettaa laudan aloitustilanteeseen, valkoiset alas, mustat ylös
 * vaihtaa vuoron valkoiselle
 */
    
    public void asetaLauta() {
        
//          valkoisen nappulat
        setNappula(new Torni(true), 0, 0);
        setNappula(new Ratsu(true), 1, 0);
        setNappula(new Lahetti(true), 2, 0);
        setNappula(new Kuningatar(true), 3, 0);
        setNappula(new Kuningas(true), 4, 0);
        setNappula(new Lahetti(true), 5, 0);
        setNappula(new Ratsu(true), 6, 0);
        setNappula(new Torni(true), 7, 0);
        for(int i = 0; i <8; i++) {
            setNappula(new Sotilas(true), i, 1);
        }
        
//          mustan nappulat
        setNappula(new Torni(false), 0, 7);
        setNappula(new Ratsu(false), 1, 7);
        setNappula(new Lahetti(false), 2, 7);
        setNappula(new Kuningatar(false), 3, 7);
        setNappula(new Kuningas(false), 4, 7);
        setNappula(new Lahetti(false), 5, 7);
        setNappula(new Ratsu(false), 6, 7);
        setNappula(new Torni(false), 7, 7);
        for(int i = 0; i <8; i++) {
            setNappula(new Sotilas(false), i, 6);
        }  
        vuoro = true;
    }
    
    
    public Nappula getNappula(int x, int y) {
        return nappulat[x][y];
    }
    
    public boolean getVuoro() {
        return vuoro;
    }
    
    /*
     * Vaihtaa vuoron toiselle pelaajalle
     */
    public void vaihdaVuoro() {
        vuoro = !vuoro;
    }
    
    /*
     * Siirtää nappulan alkuperäisestä ruudusta haluttuun ruutuun.
     * 
     * @param   alkuX   nappulan tämänhetkisen ruudun x-koordinaatti
     * @param   alkuY   nappulan tämänhetkisen ruudun y-koordinaatti
     * @param   kohdeX  halutun ruudun x-koordinaatti
     * @param   kohdeY  halutun ruudun y-koordinaatti
     */
    public void siirraNappula(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        if (nappulat[alkuX][alkuY] != null) {
            if(nappulat[alkuX][alkuY].siirra(alkuX, alkuY, kohdeX, kohdeY) == true) {
                if (oikeaVari(alkuX, alkuY) == vuoro) {
                  setNappula(nappulat[alkuX][alkuY], kohdeX, kohdeY);
                    nappulat[alkuX][alkuY].poistaNappula(this, alkuX, alkuY);
                    vaihdaVuoro();
                }
            }
        }
    }
    
    /*
     * Palauttaa true mikäli nappulan väri on valkoinen, false jos musta
     * 
     * @param   x   nappulan x-koordinaatti
     * @param   y   nappulan y-koordinaatti
     * 
     * @return boolean  riippuu nappulan väristä
     */
    
    public boolean oikeaVari(int x, int y) {
        if (nappulat[x][y].getVari()== true) {
            return true;
        } else {
            return false;
        }
    }
    

    

    
}

