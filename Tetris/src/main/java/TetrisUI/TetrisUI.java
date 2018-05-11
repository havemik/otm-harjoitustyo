package TetrisUI;

import tetris.blocks.Block;
import tetris.blocks.IBlock;
import tetris.blocks.JBlock;
import tetris.blocks.LBlock;
import tetris.blocks.SBlock;
import tetris.blocks.Square;
import tetris.blocks.TBlock;
import tetris.blocks.ZBlock;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import tetris.logic.TetrisLogic;
import tetris.blocks.Piece;
import javafx.scene.text.Text;

/**
 * Käyttöliittymän rakentava luokka
 *
 * @author Mikko
 */
public class TetrisUI extends Application {

    private double time;
    private Block current;
    private List<Block> pieces;
    private TetrisLogic logic;

    @Override
    public void start(Stage Stage) throws Exception {
        this.pieces = new ArrayList<>();
        Stage.setTitle("Tetris");
        StackPane window = new StackPane();
        Scene scene = new Scene(window, 500, 500);

        Pane game = new Pane();
        game.setPrefSize(100, 500);

        Scene scene2 = new Scene(game, 200, 400);

        Button newGame = new Button("New Game");
        newGame.setOnAction(e -> {
            Stage.setScene(scene2);
        });

        this.logic = new TetrisLogic();

        Group floor = new Group();
        Rectangle floorStart = new Rectangle(110, 10);
        floor.setTranslateY(210);
        Rectangle wall = new Rectangle(10, 220);
        wall.setTranslateX(100);
        floor.getChildren().addAll(floorStart);
        Text controls = new Text("Controls: \n Movement = Arrow Keys \n Rotate = Z or Ctrl \n Note, rotate doesn't actually work. \n Though it breaks differently \n depending on the block. \n Except for IBlocks for some reason");
        Text welcome = new Text("Welcome to this absolutely unbeliavable executed tetris clone. \n Prepare to be astonished!");
        welcome.setTranslateX(30);
        welcome.setTranslateY(-100);
        
        controls.setTranslateX(10);
        controls.setTranslateY(300);
        game.getChildren().add(controls);
        Block block = logic.createBlock();
        current = block;
        System.out.println(current.getClass().getName());
        scene2.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                logic.left(current);
            }

            if (event.getCode() == KeyCode.RIGHT) {
                logic.right(current);
            }

            if (event.getCode() == KeyCode.DOWN) {
                if (logic.isDownValidMove(current) == true) {
                    logic.down(current);
                }
            }

            if (event.getCode() == KeyCode.CONTROL) {
                logic.rotate(current, game);
            }

            if (event.getCode() == KeyCode.Z) {
                
                logic.rotate(current, game);
            }
            
        });

        new AnimationTimer() {
            @Override
            public void handle(long now) {

                time += 0.017;
                if (time >= 1.0) {
                    if(logic.isDownValidMove(current) == true){
                        logic.down(current);
                    }   else    {
                        stop();
                        logic.dropOldBlock(current);
                        game.getChildren().addAll(current.r1, current.r2, current.r3, current.r4);
                        current.getBlock().getChildren().removeAll(pieces);
                        logic.clearRows(game);
                        Block moo = logic.createBlock();
                        current = moo;
                        game.getChildren().add(current.getBlock());
                        this.start();
                    }
                    time = 0;
                }         
            }
        }.start();

        window.getChildren().addAll(newGame, welcome);
        game.getChildren().add(block.getBlock());
        game.getChildren().addAll(floor, wall);;
        Stage.setScene(scene);
        Stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
