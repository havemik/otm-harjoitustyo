/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import tetris.blocks.IBlock;
import tetris.blocks.Block;
import tetris.logic.TetrisLogic;
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

    Block block;
    TetrisLogic logic;

    public BlockTest() {
    }

    @Before
    public void setUp() {
        TetrisLogic l = new TetrisLogic();
        block = new IBlock(l);
    }

    @Test
    public void rightWorks() {
        double XAtStart = block.getR1().getTranslateX();
        block.right();
        assertEquals(XAtStart + 10, block.getR1().getTranslateX(), 0.1);
    }

    @Test
    public void leftWorks() {
        double XAtStart = block.getR1().getTranslateX();
        block.left();
        assertEquals(XAtStart - 10, block.getR1().getTranslateX(), 0.1);
    }

    @Test
    public void downWorks() {
        double YAtStart = block.getR1().getTranslateY();
        block.down();
        assertEquals(YAtStart + 10, block.getR1().getTranslateY(), 0.1);
    }
    
}
