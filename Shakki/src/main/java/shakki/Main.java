/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import Kayttoliittyma.Kayttoliittyma;



/**
 *
 * @author Henri
 */
public class Main {
    
    public static void main(String[] args) {
        Lauta lauta = new Lauta();
        Kayttoliittyma liittyma = new Kayttoliittyma(lauta);
        liittyma.aloita();
    }
    
}
