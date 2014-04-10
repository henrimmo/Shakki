/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import Nappula.Nappula;
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

    Nappula nappula;
    public LautaTest() {
    }
    
    @Before
    public void setUp() {
        lauta = new Lauta();
        lauta.asetaLauta();
    }

    @Test
    public void asettuukoNappulaOikein() {
        assertEquals("S",lauta.getNappula(0, 1).getTyyppi());
        assertEquals("K",lauta.getNappula(4, 0).getTyyppi());  
        assertEquals("q",lauta.getNappula(3, 7).getTyyppi());
    }
    
    @Test
    public void meneekoVariOikein() {
        assertEquals(false,lauta.getNappula(3, 7).getVari());
        assertEquals(true,lauta.getNappula(4, 0).getVari());  
    }
    
    @Test
    public void poistuukoNappula() {
        lauta.poistaNappula(0, 1);
        assertEquals(null, lauta.getNappula(0, 1));
    }
    
    @Test
    public void siirtyykoNappula() {
       lauta.siirraNappula(0, 0, 0, 3);
       assertEquals("T",lauta.getNappula(0, 3).getTyyppi());
    }
    
    @Test
    public void siirtyykoVainOmaNappula() {
        lauta.siirraNappula(7, 7, 7, 4);
        assertEquals("t",lauta.getNappula(7, 7).getTyyppi());
    }
    
    @Test
    public void vuoroVaihtuuOikein() {
       lauta.siirraNappula(0, 0, 0, 3);
       assertEquals("T",lauta.getNappula(0, 3).getTyyppi());
       lauta.siirraNappula(7, 7, 7, 4);
       assertEquals("t",lauta.getNappula(7, 4).getTyyppi());
       lauta.siirraNappula(7, 4, 7, 7);
       assertEquals("t",lauta.getNappula(7, 4).getTyyppi()); 
    }
    
    @Test
    public void ruudunTyhjyys() {
        assertEquals(true,lauta.onkoRuutuTyhja(4, 4));
    }
    
//    @Test
//    public void tyhjaaNappulaaEiVoiSiirtää() {
//        
//        assertEquals("Valitse ruutu jossa on nappula",lauta.siirraNappula(4, 4, 5, 5));
//    }

}
