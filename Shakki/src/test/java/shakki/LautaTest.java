/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import Nappula.Nappula;
import Nappula.Sotilas;
import Nappula.Torni;
import Nappula.Tyhja;
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
        assertEquals("d",lauta.getNappula(3, 7).getTyyppi());
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
       lauta.siirraNappula(0, 1, 0, 3);
       assertEquals("S",lauta.getNappula(0, 3).getTyyppi());
    }
    
    @Test
    public void siirtyykoVainOmaNappula() {
        lauta.siirraNappula(7, 6, 7, 4);
        assertEquals("s",lauta.getNappula(7, 6).getTyyppi());
    }
    
    @Test
    public void vuoroVaihtuuOikein() {
       lauta.siirraNappula(0, 1, 0, 2);
       assertEquals("S",lauta.getNappula(0, 2).getTyyppi());
       lauta.siirraNappula(7, 6, 7, 4);
       assertEquals("s",lauta.getNappula(7, 4).getTyyppi());
       lauta.siirraNappula(7, 4, 7, 3);
       assertEquals("s",lauta.getNappula(7, 4).getTyyppi()); 
    }
    
    @Test
    public void ruudunTyhjyys() {
        assertEquals(true,lauta.onkoRuutuTyhja(4, 4));
    }
    
    @Test
    public void ruutuValiTarkistusVaaka() {
        assertEquals(false,lauta.onkoValiTyhja(7, 0, 0, 0));
        assertEquals(false,lauta.onkoValiTyhja(0, 0, 7, 0));
        assertEquals(false,lauta.onkoValiTyhja(6, 0, 4, 0));
        assertEquals(false,lauta.onkoValiTyhja(4, 0, 6, 0));
        assertEquals(true,lauta.onkoValiTyhja(6, 0, 5, 0));
        assertEquals(true,lauta.onkoValiTyhja(5, 0, 6, 0));
        
        lauta.setNappula(new Torni(true), 1, 3);
        lauta.setNappula(new Torni(true), 6, 3);
        assertEquals(true,lauta.onkoValiTyhja(1, 3, 6, 3));
        assertEquals(true,lauta.onkoValiTyhja(6, 3, 1, 3));
    }
    
    @Test
    public void ruutuValiTarkistusPysty() {
        lauta.tyhjennaLauta();
        lauta.setNappula(new Torni(false), 2, 1);
        lauta.setNappula(new Sotilas(false), 2, 6);
        lauta.setNappula(new Torni(true), 2, 5);
        lauta.setNappula(new Tyhja(true), 2, 4);
        lauta.setNappula(new Tyhja(true), 2, 3);
        lauta.setNappula(new Tyhja(true), 2, 2);
        
        assertEquals(true,lauta.onkoValiTyhja(2, 1, 2, 5));
        assertEquals(false,lauta.onkoValiTyhja(2, 1, 2, 6));
        assertEquals(true,lauta.onkoValiTyhja(2, 4, 2, 1));
        assertEquals(false,lauta.onkoValiTyhja(2, 6, 2, 4));
        assertEquals(false,lauta.onkoValiTyhja(2, 4, 2, 6));
    }
    
    @Test
    public void ruutuValiTarkistusVino() {
        lauta.tyhjennaLauta();
        lauta.setNappula(new Torni(true), 0, 0);
        lauta.setNappula(new Torni(true), 3, 3);
        lauta.setNappula(new Torni(true), 5, 5);
        lauta.setNappula(new Torni(true), 4, 4);
        lauta.setNappula(new Tyhja(true), 2, 2);
        lauta.setNappula(new Tyhja(true), 1, 1);
        
        lauta.setNappula(new Torni(true), 7, 1);
        lauta.setNappula(new Torni(true), 1, 7);
        lauta.setNappula(new Tyhja(true), 6, 2);
        lauta.setNappula(new Tyhja(true), 5, 3);
        lauta.setNappula(new Tyhja(true), 3, 5);
        lauta.setNappula(new Tyhja(true), 2, 6);
        
        assertEquals(true,lauta.onkoValiTyhja(0, 0, 3, 3));
        assertEquals(false,lauta.onkoValiTyhja(3, 3, 5, 5));
        assertEquals(false,lauta.onkoValiTyhja(0, 0, 5, 5));
        assertEquals(true,lauta.onkoValiTyhja(7, 1, 4, 4));
        assertEquals(false,lauta.onkoValiTyhja(7, 1, 1, 7));
    }

}
