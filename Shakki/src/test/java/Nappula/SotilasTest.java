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
public class SotilasTest {

    Lauta lauta;

    Nappula nappula;
    
    public SotilasTest() {
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
    public void liikkuukoSotilasOikein() {
        lauta.poistaNappula(1, 1);
        lauta.poistaNappula(2, 6);
        lauta.setNappula(new Sotilas(true), 1, 1);
        lauta.setNappula(new Sotilas(false), 2, 6);
        
        lauta.siirraNappula(1, 1, 1, 3);
        assertEquals("S",lauta.getNappula(1, 3).getTyyppi());
        
        lauta.siirraNappula(2, 6, 2, 4);
        assertEquals("s",lauta.getNappula(2, 4).getTyyppi());
        
        lauta.siirraNappula(1, 3, 1, 4);
        assertEquals("S",lauta.getNappula(1, 4).getTyyppi());
    }
    
    @Test
    public void sotilasEiLiikuLaittomasti() {
        lauta.setNappula(new Sotilas(true), 1, 1);
        lauta.setNappula(new Sotilas(false), 2, 6);
        
        lauta.siirraNappula(1, 1, 1, 0);
        assertEquals("S",lauta.getNappula(1, 1).getTyyppi());
        
        lauta.siirraNappula(2, 6, 2, 7);
        assertEquals("s",lauta.getNappula(2, 6).getTyyppi());
        
        lauta.vaihdaVuoro();
        lauta.siirraNappula(2, 6, 2, 4);
        assertEquals("s",lauta.getNappula(2, 4).getTyyppi());
        
        lauta.vaihdaVuoro();
        lauta.siirraNappula(2, 4, 2, 2);
        assertEquals("s",lauta.getNappula(2, 4).getTyyppi());
    }
}
