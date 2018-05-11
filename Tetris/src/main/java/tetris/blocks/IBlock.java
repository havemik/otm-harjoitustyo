package tetris.blocks;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tetris.logic.TetrisLogic;

/**
 *
 * @author Mikko
 */
public class IBlock extends Block {

    public IBlock(TetrisLogic logic) {
        super(new Group(), new ArrayList<Piece>(), logic, Color.TURQUOISE);
        r1.setTranslateX(50);
        r2.setTranslateX(60);
        r3.setTranslateX(70);
        r4.setTranslateX(80);
        super.getBlock().getChildren().addAll(r1, r2, r3, r4);
        this.p1 = new Piece(5, 0, logic, r1);
        this.p2 = new Piece(6, 0, logic, r2);
        this.p3 = new Piece(7, 0, logic, r3);
        this.p4 = new Piece(8, 0, logic, r4);
    }

    @Override
    public Block rotate(Block b) {
        if(this.getDirection() == 1){
            int newX = p2.getX() + 1;
            int newY = p2.getY();
            p1.setLocation(newX, newY);
            b.getR1().setTranslateX(b.getR2().getTranslateX() + 10);
            b.getR1().setTranslateY(b.getR2().getTranslateY());
            
            int newX2 = p2.getX() - 1;
            p3.setLocation(newX2, newY);
            b.getR3().setTranslateX(b.getR2().getTranslateX() - 10);
            b.getR3().setTranslateY(b.getR2().getTranslateY());
            
            int newX3 = p2.getX() - 2;
            p4.setLocation(newX3, newY);
            b.getR4().setTranslateX(b.getR2().getTranslateX() - 20);
            b.getR4().setTranslateY(b.getR2().getTranslateY());
            
            this.setDirection(2);
        }   else if(this.getDirection() == 2){
            int newX = p2.getX();
            int newY = p2.getY() - 1;
            p1.setLocation(newX, newY);
            b.getR1().setTranslateX(b.getR2().getTranslateX());
            b.getR1().setTranslateY(b.getR2().getTranslateY() - 10);
            
            int newY2 = p2.getY() + 1;
            p3.setLocation(newX, newY2);
            b.getR3().setTranslateX(b.getR2().getTranslateX());
            b.getR3().setTranslateY(b.getR2().getTranslateY() + 10);
            
            int newY3 = p2.getY() + 2;
            p4.setLocation(newX, newY3);
            b.getR4().setTranslateX(b.getR2().getTranslateX());
            b.getR4().setTranslateY(b.getR2().getTranslateY() + 20);
            
            this.setDirection(1);
        }
        return b;
    }
}
