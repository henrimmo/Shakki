/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

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
public class RuutuTest {
    
    Ruutu ruutu;
    
    @Before
    public void setUp() {
        ruutu = new Ruutu(0,999);
    }

    @Test
    public void toimiikoRuudunSijainninTarkistaja() {
        assertEquals(false, ruutu.onkoRuudunSijaintiSallittu());
    }
}
