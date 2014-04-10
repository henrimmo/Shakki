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
public class RatsuTest {
    
    Lauta lauta;

    Nappula nappula;
    
    public RatsuTest() {
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
    public void liikkuukoRatsuOikein() {
        lauta.poistaNappula(4, 4);
        lauta.setNappula(new Ratsu(true), 4, 4);
        lauta.siirraNappula(4, 4, 5, 6);
        assertEquals("R",lauta.getNappula(5, 6).getTyyppi());
        
        lauta.vaihdaVuoro();
        lauta.siirraNappula(5, 6, 3, 7);
        assertEquals("R",lauta.getNappula(3, 7).getTyyppi());
        
        lauta.vaihdaVuoro();
        lauta.siirraNappula(3, 7, 1, 6);
        assertEquals("R",lauta.getNappula(1, 6).getTyyppi());
    }
    
    @Test
    public void ratsuEiLiikuLaittomasti() {
        lauta.setNappula(new Ratsu(true), 4, 4);
        lauta.siirraNappula(4, 4, 5, 5);
        assertEquals("R",lauta.getNappula(4, 4).getTyyppi()); 
        
        lauta.vaihdaVuoro();
        lauta.siirraNappula(4, 4, 2, 4);
        assertEquals("R",lauta.getNappula(4, 4).getTyyppi());
    }
}
