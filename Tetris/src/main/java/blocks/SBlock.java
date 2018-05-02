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
 *
 * @author Mikko
 */
public class SBlock extends Block{

    public SBlock(){
        super(new Group());
        Rectangle r = new Rectangle(40, 20, Color.GOLD);
        Rectangle r2 = new Rectangle(40, 20, Color.GOLD);
        r.setTranslateX(20);
        r.setTranslateY(20);
        super.getBlock().getChildren().addAll(r, r2);
    }
}
