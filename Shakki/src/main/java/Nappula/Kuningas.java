/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappula;

/**
 *
 * @author Henri
 */
public class Kuningas extends Nappula{
    
    public Kuningas(int x, int y, boolean vari) {
        super(x, y, vari);
        if (vari = true) {
            tyyppi = 'K';
        } else {
            tyyppi = 'k';
        }
    }
}
