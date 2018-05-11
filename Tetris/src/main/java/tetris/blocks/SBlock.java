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
 * Tekee S Paloja.
 *
 * @author Mikko
 */
public class SBlock extends Block {

    public SBlock(TetrisLogic logic) {
        super(new Group(), new ArrayList<Piece>(), logic, Color.DARKMAGENTA);
        r1.setTranslateX(50);
        r2.setTranslateX(60);
        r3.setTranslateX(50);
        r3.setTranslateY(10);
        r4.setTranslateX(40);
        r4.setTranslateY(10);
        super.getBlock().getChildren().addAll(r1, r2, r3, r4);
        this.p1 = new Piece(5, 0, logic, r1);
        this.p2 = new Piece(6, 0, logic, r2);
        this.p3 = new Piece(5, 1, logic, r3);
        this.p4 = new Piece(4, 1, logic, r4);
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
        if(this.getDirection() == 1){
            int newX = p3.getX() + 1;
            int newY = p3.getY();
            p1.setLocation(newX, newY);
            b.r1.setTranslateX(b.r3.getTranslateX() + 10);
            b.r1.setTranslateY(b.r3.getTranslateY());
            
            int newY2 = p3.getY() + 1;
            p2.setLocation(newX, newY2);
            b.r2.setTranslateX(b.r3.getTranslateX() + 10);
            b.r2.setTranslateY(b.r3.getTranslateY() + 10);
            
            int newX3 = p3.getX();
            int newY3 = p3.getY() - 1;
            p4.setLocation(newX3, newY3);
            b.r4.setTranslateX(b.r3.getTranslateX());
            b.r4.setTranslateY(b.r3.getTranslateY() - 10);
            
            this.setDirection(2);
        }
        if(this.getDirection() == 2){
            int newX = p3.getX() + 1;
            int newY = p3.getY();
            p1.setLocation(newX, newY);
            b.r1.setTranslateX(b.r3.getTranslateX() + 10);
            b.r1.setTranslateY(b.r3.getTranslateY());
            
            int newX2 = p3.getX();
            int newY2 = p3.getY() + 1;
            p2.setLocation(newX2, newY2);
            b.r2.setTranslateX(b.r3.getTranslateX());
            b.r2.setTranslateY(b.r3.getTranslateY() + 10);
            
            int newX3 = p3.getX() - 1;
            p4.setLocation(newX3, newY2);
            b.r4.setTranslateX(b.r3.getTranslateX() - 10);
            b.r4.setTranslateY(b.r3.getTranslateY() + 10);
            this.setDirection(1);
        }
        return b;
    }
}
