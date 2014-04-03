/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nappula;

import shakki.Lauta;


/**
 *
 * @author henrimmo
 */
public class Nappula {
    
    public int x;
    public int y;
    
    //isot kirjaimet valkoisia, pienet mustia
    public char tyyppi;
    
    //true = valkoinen, false = musta
    private boolean vari;
    
    
    
    public Nappula(int x, int y, boolean vari) {
        this.x = x;
        this.y = y;
        this.vari = vari;
        
    }
    

    
}
