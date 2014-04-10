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
public class LahettiTest {
    
    Lauta lauta;
    Nappula nappula;
    
    
    public LahettiTest() {
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
    public void liikkuukoLahettiOikein() {
        lauta.poistaNappula(0, 0);
        lauta.setNappula(new Lahetti(true), 0, 0);
        lauta.siirraNappula(0, 0, 4, 4);
        assertEquals("L",lauta.getNappula(4, 4).getTyyppi());
        
        lauta.vaihdaVuoro();
        lauta.siirraNappula(4, 4, 7, 1);
        assertEquals("L",lauta.getNappula(7, 1).getTyyppi());
    }
    
 
    
    
}
