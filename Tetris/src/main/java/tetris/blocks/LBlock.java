
package tetris.blocks;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tetris.logic.TetrisLogic;

/**
 *Tekee L paloja
 * 
 * @author Mikko
 */

public class LBlock extends Block{

    public LBlock(TetrisLogic logic){
        super(new Group(), new ArrayList<Piece>(), logic, Color.RED);
        r1.setTranslateX(50);
        r2.setTranslateX(60);
        r3.setTranslateX(70);
        r4.setTranslateX(50);
        r4.setTranslateY(10);
        super.getBlock().getChildren().addAll(r1, r2, r3, r4);
        this.p1 = new Piece(5, 0, logic, r1);
        this.p2 = new Piece(6, 0, logic, r2);
        this.p3 = new Piece(7, 0, logic, r3);
        this.p4 = new Piece(5, 1, logic, r4);
    }
    
    /**
     * TODO
     * Metodi kääntää annetun palikan seuraavaan asentoon.
     *
     * @param   b  Mikä pala halutaan kääntää
     * 
     * @return käännetty pala
     */
    @Override
    public Block rotate(Block b) {
        if(this.getDirection() == 1){
            
            this.setDirection(2);
        }
        if(this.getDirection() == 2){
            
            this.setDirection(3);
        }
        if(this.getDirection() == 3){
            
            this.setDirection(4);
        }
        if(this.getDirection() == 4){
            
            this.setDirection(1);
        }
        return b;
    }
    
    
}
