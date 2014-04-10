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
public class KuningasTest {
    

    Lauta lauta;

    Nappula nappula;
    
    public KuningasTest() {
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
    public void liikkuukoKuningasOikein() {
        lauta.poistaNappula(4, 4);
        lauta.setNappula(new Kuningas(true), 4, 4);
        lauta.siirraNappula(4, 4, 5, 5);
        assertEquals("K",lauta.getNappula(5, 5).getTyyppi());
        lauta.vaihdaVuoro();
        lauta.siirraNappula(5, 5, 4, 5);
        lauta.vaihdaVuoro();
        assertEquals("K",lauta.getNappula(4, 5).getTyyppi());
        lauta.siirraNappula(4, 5, 3, 4);
        assertEquals("K",lauta.getNappula(3, 4).getTyyppi());

    }
    
    @Test
    public void kuningasEiLiikuLaittomasti() {
        lauta.setNappula(new Kuningas(true), 4, 4);
        lauta.siirraNappula(4, 4, 6, 4);
        assertEquals("K",lauta.getNappula(4, 4).getTyyppi());
    }
}
