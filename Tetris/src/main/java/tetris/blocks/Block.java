package tetris.blocks;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tetris.logic.TetrisLogic;

/**
 * Kaikkien palojan yhteinen toiminnallisuus tässä luokassa
 * Jokainen pala koostuu neljästä osasta, ja niitä käsitellään osiensa kautta, vaikka ne näyttävät yhtenäisiltä.
 * Osat on jaettu Rectangle olioihin, jotka piirretään käyttöliittymään ja Piece olioihin jotka merkitään sovelluslogiikkaan.
 * 
 * @author Mikko
 */
public abstract class Block{

    private Group block;
    private boolean crash;
    private List<Rectangle> pieces;
    private TetrisLogic logic;
    public Piece p1, p2, p3, p4;
    public Rectangle r1, r2, r3, r4;
    private int direction;

    public Block(Group g, List<Piece> pieces, TetrisLogic logic, Color paint) {
        this.r1 = new Rectangle(10, 10, paint);
        this.r2 = new Rectangle(10, 10, paint);
        this.r3 = new Rectangle(10, 10, paint);
        this.r4 = new Rectangle(10, 10, paint);
        this.block = g;
        this.pieces = new ArrayList<>();
        this.pieces.add(r1);
        this.pieces.add(r2);
        this.pieces.add(r3);
        this.pieces.add(r4);
        this.direction = 1;
    }
    
    final public int getDirection(){
        return direction;
    }
    
    final public void setDirection(int d){
        this.direction = d;
    }

    final public Group getBlock() {
        return block;
    }
    
    final public TetrisLogic getLogic(){
        return logic;
    }
    
    final public List getPieces(){
        return pieces;
    }
    
    final public Rectangle getR1(){
        return r1;
    }
    
    final public Rectangle getR2(){
        return r2;
    }   
    
    final public Rectangle getR3(){
        return r3;
    }
    
    final public Rectangle getR4(){
        return r4;
    }
    
    /**
    *Metodi siirtää palan jokaista osaa 10 pikseliä vasemmalle
    *
    */
    final public void left() {
        this.block.getChildren().forEach(a -> a.setTranslateX(a.getTranslateX() - 10));
    }
    
    /**
    *Metodi siirtää palan jokaista osaa 10 pikseliä oikealle
    *
    */
    final public void right() {
        this.block.getChildren().forEach(a -> a.setTranslateX(a.getTranslateX() + 10));
    }

    /**
    *Metodi siirtää palan jokaista osaa 10 pikseliä alaspäin
    *
    */
    final public void down() {
        this.block.getChildren().forEach(a -> a.setTranslateY(a.getTranslateY() + 10));
    }
    
    public Block rotate(Block b){
        return b;
    }

    public Piece getP1() {
        return p1;
    }

    public Piece getP2() {
        return p2;
    }

    public Piece getP3() {
        return p3;
    }

    public Piece getP4() {
        return p4;
    }
}
