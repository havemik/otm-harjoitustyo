/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TetrisLogic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.blocks.Block;
import tetris.logic.TetrisLogic;

/**
 *
 * @author Mikko
 */
public class TetrisLogicTest {

    private TetrisLogic logic;
    private Block b;

    public TetrisLogicTest() {

    }

    @Before
    public void setUp() {
        this.logic = new TetrisLogic();
        this.b = logic.createBlock();

    }

    @Test
    public void locationInArrayIsUpdated(){
        logic.down(b);
        logic.left(b);
        logic.left(b);
        logic.right(b);
        logic.down(b);
        logic.down(b);
        logic.down(b);
        assertEquals(logic.getPieceMap()[4][4], 1);
    }
    
    @Test
    public void oldLocationIsClear(){
        logic.down(b);
        logic.down(b);
        logic.down(b);
        logic.down(b);
        logic.left(b);
        assertEquals(logic.getPieceMap()[5][0], 0);
    }
    
    @Test
    public void leftDoesntTakeBlockOut(){
        logic.left(b);
        logic.left(b);
        logic.left(b);
        logic.left(b);
        logic.left(b);
        logic.left(b);
        logic.left(b);
        logic.left(b);
        logic.left(b);
        assertEquals(logic.getPieceMap()[0][0], 1);
    }
    
    @Test
    public void rightDoesntTakeBlockOut(){
        logic.right(b);
        logic.right(b);
        logic.right(b);
        logic.right(b);
        logic.right(b);
        logic.right(b);
        logic.right(b);
        logic.right(b);
        logic.right(b);
        assertEquals(logic.getPieceMap()[8][0], 1);
    }
}
