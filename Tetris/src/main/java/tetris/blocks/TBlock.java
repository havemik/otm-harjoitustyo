/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.blocks;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tetris.logic.TetrisLogic;

/**
 * Tekee T paloja
 *
 * @author Mikko
 */
public class TBlock extends Block {

    public TBlock(TetrisLogic logic) {
        super(new Group(), new ArrayList<Piece>(), logic, Color.BURLYWOOD);
        r1.setTranslateX(50);
        r2.setTranslateX(40);
        r3.setTranslateX(60);
        r4.setTranslateX(50);
        r4.setTranslateY(10);
        super.getBlock().getChildren().addAll(r1, r2, r3, r4);
        this.p1 = new Piece(5, 0, logic, r1);
        this.p2 = new Piece(4, 0, logic, r2);
        this.p3 = new Piece(6, 0, logic, r3);
        this.p4 = new Piece(5, 1, logic, r4);
    }

     /**
     * Metodi kääntää annetun palikan seuraavaan asentoon.
     *
     * @param   b  Mikä pala halutaan kääntää
     * 
     * @return käännetty pala
     */
    @Override
    public Block rotate(Block b) {
        //something else I tested
        Rectangle r2 = new Rectangle(10, 10, Color.BURLYWOOD);
        Rectangle r3 = new Rectangle(10, 10, Color.BURLYWOOD);
        Rectangle r4 = new Rectangle(10, 10, Color.BURLYWOOD);
        b.getBlock().getChildren().removeAll(b.r2, b.r3, b.r4);
        if (this.getDirection() == 1) {
            int newX = p1.getX();
            int newY = p1.getY() - 1;
            p2.setLocation(newX, newY);
            r2.setTranslateY(r1.getTranslateX());
            r2.setTranslateY(r1.getTranslateY() - 10);

            int newY2 = p1.getY() + 1;
            p3.setLocation(newX, newY2);
            r3.setTranslateX(r1.getTranslateX());
            r3.setTranslateY(r1.getTranslateY() + 10);

            int newX3 = p1.getX() - 1;
            int newY3 = p1.getY();
            p4.setLocation(newX3, newY3);
            r4.setTranslateX(b.r1.getTranslateX() - 10);
            r4.setTranslateY(b.r1.getTranslateY());

            this.setDirection(2);
        }
        if (this.getDirection() == 2) {
            int newX = p1.getX();
            int newY = p1.getY() - 1;
            p2.setLocation(newX, newY);
            r2.setTranslateX(b.r1.getTranslateX());
            r2.setTranslateY(b.r1.getTranslateY() - 10);

            int newX2 = p1.getX() - 1;
            int newY2 = p1.getY();
            p2.setLocation(newX2, newY2);
            r3.setTranslateX(b.r1.getTranslateX() - 10);
            r3.setTranslateY(b.r1.getTranslateY());

            int newX3 = p1.getX() + 1;
            p2.setLocation(newX3, newY2);
            r4.setTranslateX(b.r1.getTranslateX() + 10);
            r4.setTranslateY(b.r1.getTranslateY());

            this.setDirection(3);
        }
        if (this.getDirection() == 3) {
            int newX = p1.getX() + 1;
            int newY = p1.getY();
            p2.setLocation(newX, newY);
            r2.setTranslateX(b.r1.getTranslateX() + 10);
            r2.setTranslateY(b.r1.getTranslateY());

            int newX2 = p1.getX();
            int newY2 = p1.getY() - 1;
            p3.setLocation(newX2, newY2);
            r3.setTranslateX(b.r1.getTranslateX());
            r3.setTranslateY(b.r1.getTranslateY() - 10);

            int newX3 = p1.getX() - 1;
            p4.setLocation(newX3, newY);
            r4.setTranslateX(b.r1.getTranslateX() - 10);
            r4.setTranslateY(b.r1.getTranslateY());

            this.setDirection(4);
        }
        if (this.getDirection() == 4) {
            int newX = p1.getX();
            int newY = p1.getY() + 1;
            p2.setLocation(newX, newY);
            r2.setTranslateX(b.r1.getTranslateX());
            r2.setTranslateY(b.r1.getTranslateY() + 10);
            
            int newX2 = p1.getX() + 1;
            int newY2 = p1.getY();
            p3.setLocation(newX2, newY2);
            r3.setTranslateX(b.r1.getTranslateX() + 10);
            r3.setTranslateY(b.r1.getTranslateY());
            
            int newX3 = p1.getX() - 1;
            p4.setLocation(newX3, newY2);
            r4.setTranslateX(b.r1.getTranslateX() - 10);
            r4.setTranslateY(b.r1.getTranslateY());
            this.setDirection(1);
        }
        b.getBlock().getChildren().addAll(r2, r3, r4);
        return b;
    }
}
