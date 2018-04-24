package Blocks;

import java.util.List;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Shape;

public abstract class Block {

    private Group block;
    private Point2D movement;
    private boolean crash;

    public Block(Group g) {
        this.block = g;
        block.setTranslateX(50);
        this.movement = new Point2D(0, 0);
    }

    public Group getBlock() {
        return block;
    }

    public void move() {
        this.block.setTranslateY(block.getTranslateY() + 10);
    }

    public void left() {
        if (this.block.getTranslateX() >= 10) {
            this.block.setTranslateX(block.getTranslateX() - 10);
        }
    }

    public void right() {
        if (this.block.getTranslateX() < 290) {
            this.block.setTranslateX(block.getTranslateX() + 10);
        }
    }

    public void down() {
        this.block.setTranslateY(block.getTranslateY() + 10);
    }

    public boolean collision(Group floor, List<Block> list) {
        this.crash = false;
        Bounds moo = this.getBlock().getBoundsInParent();
        Bounds maa = floor.getBoundsInParent();
        if (moo.intersects(maa)){
            return true;
        }
        
        list.stream().forEach(a ->{
            Bounds muu = a.getBlock().getBoundsInParent();
            if(muu.intersects(moo)){
                 this.crash = true;
                 
            }
        });
        return crash;
    }

}
