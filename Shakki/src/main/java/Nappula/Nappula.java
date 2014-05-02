/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nappula;

import shakki.Lauta;




/**
 *Abstrakti yläluokka, jonka eri nappulat perivät.
 * @author henrimmo
 */
public abstract class Nappula {
    
    public int x;
    public int y;
    
/*
 * Nappulan tyyppi String-muuttujana
 * Isot kirjaimet valkoisia, pienet mustia.
 * 
 * S = Sotilas
 * T = Torni
 * R = Ratsu
 * L = Lähetti
 * Q = Kuningatar
 * K = kuningas
 */
    public String tyyppi;
    
/*
 * Nappulan väri boolean muuttujana
 * true = valkoinen
 * false = musta
 */
    private boolean vari;
    
    
    
    public Nappula(int x, int y, boolean vari) {
        this.x = x;
        this.y = y;
        this.vari = vari;   
    }
    
    public Nappula(boolean vari) {
        this.vari = vari;
    }
    
    public boolean getVari() {
        return vari;
    }
    
    
    /*
     * Tarkistaa, onko haluttu siirto laudan rajojen sisäpuolella.
     * Palauttaa true jos on, false jos ei.
     * 
     * @param   alkuX   alkuperäinen x-koordinaatti
     * @param   alkuY   alkuperäinen y-koordinaatti
     * @param   kohdeX  haluttu x-koordinaatti
     * @param   kohdeY  haluttu y-koordinaatti
     * 
     * @return  boolean riippuu olivatko koordinaatit laudan sisällä
     */
    public boolean siirtoLaudalla(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        if(alkuX >= 0 && alkuX <8 && alkuY >= 0 && alkuY < 8 && kohdeX >= 0 && kohdeX <8 && kohdeY >= 0 && kohdeY <8) {
            return true;
        } else {
            return false;
        }
    }
    
    /*
     * abstrakti metodi, jokaisella nappulalla on oma siirtosääntönsä
     */
    public abstract boolean siirra(int alkuX, int alkuY, int kohdeX, int kohdeY);
    
    public String getTyyppi() {
        return tyyppi;
    }

    public boolean getEkaSiirto() {
        return false;
    }


}
