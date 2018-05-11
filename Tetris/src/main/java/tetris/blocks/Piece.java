/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.blocks;

import javafx.scene.shape.Rectangle;
import tetris.logic.TetrisLogic;

/**
 *
 * @author Mikko
 */
public class Piece {

    public int x, y;
    private TetrisLogic game;
    private Rectangle parent;

    public Piece(int x, int y, TetrisLogic game, Rectangle parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
        this.game = game;
        game.getPieceMap()[x][y] = 1;
    }

    public int getX() {
        return x;
    }

    public Rectangle getParent() {
        return parent;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setLocation(int x, int y){
        game.getPieceMap()[this.x][this.y] = 0;
        this.x = x;
        this.y = y;
        game.getPieceMap()[x][y] = 1;
    }

}
