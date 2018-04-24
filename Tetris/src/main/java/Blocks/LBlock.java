
package Blocks;

import static java.awt.Color.red;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class LBlock extends Block{
    

    public LBlock(){
        super(new Group());
        Rectangle r = new Rectangle(20, 40);
        Rectangle r2 = new Rectangle(40, 20);
        r2.setTranslateX(20);
        super.getBlock().getChildren().addAll(r, r2);
    }
    
    
}
