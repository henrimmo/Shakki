/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappula;

/**
 *
 * @author Henri
 */
public class Ratsu extends Nappula{
    
    public Ratsu(int x, int y, boolean vari) {
        super(x, y, vari);
        if (vari = true) {
            tyyppi = 'R';
        } else {
            tyyppi = 'r';
        }
    }
}
