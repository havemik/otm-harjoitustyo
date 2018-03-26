/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mikko
 */
public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(500);
    }
    
    @Test
    public void kassanAlkuTilanneKunnossa(){
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateisOstoToimiiEdullinen(){
        assertEquals(10, kassa.syoEdullisesti(250));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(100240, kassa.kassassaRahaa());
        assertEquals(230, kassa.syoEdullisesti(230));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void kateisOstoToimiiMaukas(){
       assertEquals(10, kassa.syoMaukkaasti(410));
       assertEquals(1, kassa.maukkaitaLounaitaMyyty());
       assertEquals(100400, kassa.kassassaRahaa());
       assertEquals(300, kassa.syoMaukkaasti(300));
       assertEquals(1, kassa.maukkaitaLounaitaMyyty());
       assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiOstoToimiiEdullinen(){
        assertTrue(kassa.syoEdullisesti(kortti));
        assertTrue(kassa.syoEdullisesti(kortti));
        assertFalse(kassa.syoEdullisesti(kortti));
        assertEquals(20, kortti.saldo());
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(2, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttiOstoToimiiMaukas(){
        assertTrue(kassa.syoMaukkaasti(kortti));
        assertFalse(kassa.syoMaukkaasti(kortti));
        assertEquals(100, kortti.saldo());
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortilleRahanLataaminenToimiiOikein(){
        kassa.lataaRahaaKortille(kortti, 100);
        kassa.lataaRahaaKortille(kortti, -50);
        assertEquals(600, kortti.saldo());
        assertEquals(100100, kassa.kassassaRahaa());
    }
}
