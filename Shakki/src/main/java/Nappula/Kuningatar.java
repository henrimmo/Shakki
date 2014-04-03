/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappula;

/**
 *
 * @author Henri
 */
public class Kuningatar extends Nappula{
    
    public Kuningatar(int x, int y, boolean vari) {
        super(x, y, vari);
        if (vari = true) {
            tyyppi = 'Q';
        } else {
            tyyppi = 'q';
        }
    }
}
