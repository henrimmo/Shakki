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
public class TorniTest {
    Lauta lauta;

    Nappula nappula;
    
    public TorniTest() {
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
    public void liikkuukoTorniOikein() {
        lauta.poistaNappula(0, 0);
        lauta.setNappula(new Torni(true), 0, 0);
        lauta.siirraNappula(0, 0, 7, 0);
        assertEquals("T",lauta.getNappula(7, 0).getTyyppi());
        
        lauta.vaihdaVuoro();
        lauta.siirraNappula(7, 0, 7, 7);
        assertEquals("T",lauta.getNappula(7, 7).getTyyppi());
        
        lauta.vaihdaVuoro();
        lauta.siirraNappula(7, 7, 7, 0);
        assertEquals("T",lauta.getNappula(7, 0).getTyyppi());
    }
}
