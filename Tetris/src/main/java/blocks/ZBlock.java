/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *Tekee Z paloja
 * 
 * @author Mikko
 */
public class ZBlock extends Block{

    public ZBlock(){
        super(new Group());
        Rectangle r = new Rectangle(40, 20, Color.DARKMAGENTA);
        Rectangle r2 = new Rectangle(40, 20, Color.DARKMAGENTA);
        r2.setTranslateX(20);
        r2.setTranslateY(20);
        super.getBlock().getChildren().addAll(r, r2);
    }
}
