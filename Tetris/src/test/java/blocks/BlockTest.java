/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testaa paloja
 *
 * @author Mikko
 */
public class BlockTest {

    public BlockTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void rightWorks() {
        Square square = new Square();
        double XAtStart = square.getBlock().getTranslateX();
        square.right();
        assertEquals(XAtStart + 10, square.getBlock().getTranslateX(), 0.1);
    }

    @Test
    public void leftWorks() {
        Square square = new Square();
        double XAtStart = square.getBlock().getTranslateX();
        square.left();
        assertEquals(XAtStart - 10, square.getBlock().getTranslateX(), 0.1);
    }
    
    @Test
    public void downWorks(){
        Square square = new Square();
        double YAtStart = square.getBlock().getTranslateY();
        square.down();
        assertEquals(YAtStart + 10, square.getBlock().getTranslateY(), 0.1);
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
