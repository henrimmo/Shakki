/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shakki.shakki;

/**
 *
 * @author henrimmo
 */
public class Siirto {
    
    private Ruutu alku;
    private Ruutu kohde;
    
    public Siirto(Ruutu alku, Ruutu kohde) {
        this.alku = alku;
        this.kohde = kohde;
    }
    
    public Ruutu getAlku() {
        return alku;
    }
    
    public Ruutu getKohde() {
        return kohde;
    }
    
    public void siirry() {
        kohde = alku;
    }
    
    
}
