/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import Nappula.Nappula;
import Nappula.Tyyppi;
import Nappula.Vari;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henri
 */
public class LautaTest {
    
    Lauta lauta;
    Ruutu ruutu;
    Nappula nappula;
    public LautaTest() {
    }
    
    @Before
    public void setUp() {
        lauta = new Lauta();
        ruutu = new Ruutu(0,0);
        nappula = new Nappula(0, 0, Tyyppi.SOTILAS, Vari.VALKOINEN);
    }

    @Test
    public void asettuukoNappulaOikein() {
    lauta.asetaNappula(ruutu, nappula);
    assertEquals("VALKOINEN SOTILAS, sijainti: 0,0", nappula.toString());
    }
}
