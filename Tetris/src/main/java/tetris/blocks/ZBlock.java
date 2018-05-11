/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.blocks;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import tetris.logic.TetrisLogic;

/**
 * Tekee Z paloja
 *
 * @author Mikko
 */
public class ZBlock extends Block {

    public ZBlock(TetrisLogic logic) {
        super(new Group(), new ArrayList<Piece>(), logic, Color.GOLD);
        this.r1.setTranslateX(50);
        this.r2.setTranslateX(60);
        this.r3.setTranslateX(60);
        this.r3.setTranslateY(10);
        this.r4.setTranslateX(70);
        this.r4.setTranslateY(10);
        super.getBlock().getChildren().addAll(r1, r2, r3, r4);
        this.p1 = new Piece(5, 0, logic, r1);
        this.p2 = new Piece(6, 0, logic, r2);
        this.p3 = new Piece(6, 1, logic, r3);
        this.p4 = new Piece(7, 1, logic, r4);
    }

    @Override
    public Block rotate(Block b) {
        if(this.getDirection() == 1){
            int newX = p2.getX();
            int newY = p2.getY() - 1;
            p1.setLocation(newX, newY);
            b.r1.setTranslateX(b.r2.getTranslateX());
            b.r1.setTranslateY(b.r2.getTranslateY() - 10);
            
            int newX2 = p2.getX() - 1;
            int newY2 = p2.getY();
            p3.setLocation(newX2, newY2);
            b.r3.setTranslateX(b.r2.getTranslateX() - 10);
            b.r3.setTranslateY(b.r2.getTranslateY());
            
            int newY3 = p2.getY() + 1;
            p4.setLocation(newX2, newY3);
            b.r4.setTranslateX(b.r2.getTranslateX() - 10);
            b.r4.setTranslateY(b.r2.getTranslateY() + 10);
            
            this.setDirection(2);
        }
        if(this.getDirection() == 2){
            int newX = p2.getX() - 1;
            int newY = p2.getX();
            p1.setLocation(newX, newY);
            b.r1.setTranslateX(b.r2.getTranslateX() - 10);
            b.r1.setTranslateY(b.r2.getTranslateY());
            
            int newX2 = p2.getX();
            int newY2 = p2.getY() + 1;
            p3.setLocation(newX2, newY2);
            b.r3.setTranslateX(b.r2.getTranslateX());
            b.r3.setTranslateX(b.r1.getTranslateY() + 10);
            
            int newX3 = p2.getX() + 1;
            p4.setLocation(newX3, newY2);
            b.r4.setTranslateX(b.r2.getTranslateX() + 10);
            b.r4.setTranslateY(b.r2.getTranslateY() + 10);
            
            this.setDirection(1);
        }
        return b;
    }
}
