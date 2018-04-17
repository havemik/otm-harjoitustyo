/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blocks;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Mikko
 */
public class Square {

    private Rectangle square;
    private Point2D movement;

    public Square() {
        this.square = new Rectangle(20, 20);
        square.setTranslateX(50);
        this.movement = new Point2D(0, 0);
    }

    public Rectangle getSquare() {
        return square;
    }

    public void move() {
        this.square.setTranslateY(square.getTranslateY() + 10);
    }

    public void left() {
        if (this.square.getTranslateX() >= 10) {
            this.square.setTranslateX(square.getTranslateX() - 10);
        }
    }

    public void right() {
        if (this.square.getTranslateX() < 290) {
            this.square.setTranslateX(square.getTranslateX() + 10);
        }
    }
    
    public void down(){
        this.square.setTranslateY(square.getTranslateY() + 10);
    }

    public boolean collision(Shape floor) {
        Shape collisionArea = Shape.intersect(this.getSquare(), floor);
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }

}
