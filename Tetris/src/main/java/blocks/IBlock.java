package blocks;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Mikko
 */
public class IBlock extends Block{

    public IBlock(){
        super(new Group());
        Rectangle r = new Rectangle(80, 20, Color.TURQUOISE);
        super.getBlock().getChildren().add(r);
    }
}
