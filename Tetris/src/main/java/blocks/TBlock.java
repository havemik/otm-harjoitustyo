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
 * Tekee T paloja
 *
 * @author Mikko
 */
public class TBlock extends Block{

    public TBlock(){
        super(new Group());
        Rectangle r = new Rectangle(60, 20, Color.BURLYWOOD);
        Rectangle r2 = new Rectangle(20, 20, Color.BURLYWOOD);
        r2.setTranslateX(20);
        r2.setTranslateY(20);
        super.getBlock().getChildren().addAll(r, r2);
    }
}
