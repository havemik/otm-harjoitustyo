/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blocks;



import javafx.scene.Group;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author Mikko
 */
public class Square extends Block {

    public Square() {
        super(new Group());
        Rectangle r = new Rectangle(20, 20);
        super.getBlock().getChildren().add(r);
    }

}
