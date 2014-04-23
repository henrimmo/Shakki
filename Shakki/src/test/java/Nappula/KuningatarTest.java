/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappula;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakki.Lauta;

/**
 *
 * @author Henri
 */
public class KuningatarTest {
    Lauta lauta;

    Nappula nappula;
    
    public KuningatarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
      
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lauta = new Lauta();
        lauta.setVuoroValk(); 
        lauta.asetaTyhjaLauta();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void liikkuukoKuningatarOikein() {
        lauta.poistaNappula(0, 0);
        lauta.setNappula(new Kuningatar(true), 0, 0);
        lauta.siirraNappula(0, 0, 7, 7);
        assertEquals("D",lauta.getNappula(7, 7).getTyyppi());
        lauta.vaihdaVuoro();
        lauta.siirraNappula(7, 7, 0, 7);
        assertEquals("D",lauta.getNappula(0, 7).getTyyppi());
        lauta.vaihdaVuoro();
        lauta.siirraNappula(0, 7, 0, 0);
        assertEquals("D",lauta.getNappula(0, 0).getTyyppi());
    }
    
    @Test
    public void kuningatarEiLiikuLaittomasti() {
        lauta.setNappula(new Kuningatar(true), 4, 4);
        lauta.siirraNappula(4, 4, 3, 1);
        assertEquals("D",lauta.getNappula(4, 4).getTyyppi());
        lauta.vaihdaVuoro();
        lauta.siirraNappula(4, 4, 0, 6);
        assertEquals("D",lauta.getNappula(4, 4).getTyyppi());
        lauta.vaihdaVuoro();
        lauta.siirraNappula(4, 4, 3, 6);
        assertEquals("D",lauta.getNappula(4, 4).getTyyppi());        
    }
}
