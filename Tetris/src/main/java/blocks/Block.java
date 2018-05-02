package blocks;

import java.util.List;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;

/**
 *Kaikkien palojan yhteinen toiminnallisuus tässä luokassa
 * 
 * @author Mikko
 */
public abstract class Block {

    private Group block;
    private Point2D movement;
    private boolean crash;

    public Block(Group g) {
        this.block = g;
        block.setTranslateX(50);
        this.movement = new Point2D(0, 0);
    }

    final public Group getBlock() {
        return block;
    }
    
    /**
    *Metodi siirtää palaa 10 pikseliä vasemmalle
    *
    */
    final public void left() {
        if (this.block.getTranslateX() >= 10) {
            this.block.setTranslateX(block.getTranslateX() - 10);
        }
    }
    
    /**
    *Metodi siirtää palaa 10 pikseliä oikealle
    *
    */
    final public void right() {
        if (this.block.getTranslateX() < 290) {
            this.block.setTranslateX(block.getTranslateX() + 10);
        }
    }

    /**
    *Metodi siirtää palaa 10 pikseliä alaspäin
    *
    */
    final public void down() {
        this.block.setTranslateY(block.getTranslateY() + 10);
    }
    
    /**
    *Metodi kääntää palaa 90 astetta myötäpäivään
    *
    */
    final public void rotate(){
        this.block.setRotate(this.block.getRotate() + 90);
    }

    
    /**
    *Metodin on tarkoitus tarkistaa onko juuri putoava pala törmäämässä johonkin
    * <p>
    * Does not currently work as intended
    *
    * @param floor tason pohja
    * @param list lista tähän asti pelatuista paloista
    * 
    * @return palauttaa true jos kaksi palaa törmäävät toisiinsa
    */
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
