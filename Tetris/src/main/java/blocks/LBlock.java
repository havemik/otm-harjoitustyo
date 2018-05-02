
package blocks;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *Tekee L paloja
 * 
 * @author Mikko
 */

public class LBlock extends Block{
    

    public LBlock(){
        super(new Group());
        Rectangle r = new Rectangle(20, 40, Color.RED);
        Rectangle r2 = new Rectangle(40, 20, Color.RED);
        r2.setTranslateX(20);
        super.getBlock().getChildren().addAll(r, r2);
    }
    
    
}
