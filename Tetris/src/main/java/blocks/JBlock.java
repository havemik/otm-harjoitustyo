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
 *Tekee J paloja
 * 
 * @author Mikko
 */
public class JBlock extends Block{
    
    public JBlock(){
        super(new Group());
        Rectangle r = new Rectangle(40, 20, Color.BLUE);
        Rectangle r2 = new Rectangle(20, 40, Color.BLUE);
        r2.setTranslateX(40);
        super.getBlock().getChildren().addAll(r, r2);
    }
    
}
