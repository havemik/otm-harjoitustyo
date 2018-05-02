package TetrisUI;

import blocks.Block;
import blocks.IBlock;
import blocks.JBlock;
import blocks.LBlock;
import blocks.SBlock;
import blocks.Square;
import blocks.TBlock;
import blocks.ZBlock;
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
import javafx.scene.shape.Rectangle;

/**
 *Käyttöliittymän rakentava luokka
 * 
 * @author Mikko
 */

public class TetrisUI extends Application {
    
    private double time;
    private Block current;
    private List<Block> pieces;
    
    @Override
    public void start(Stage Stage) throws Exception {
        this.pieces = new ArrayList<>();
        Stage.setTitle("Tetris");
        Pane window = new Pane();
        Scene scene = new Scene(window, 500, 500);
        
        Pane game = new Pane();
        game.setPrefSize(100, 500);
        
        Scene scene2 = new Scene(game, 300, 600);
        
        Button newGame = new Button("New Game");
        newGame.setOnAction(e -> {
            Stage.setScene(scene2);
        });
        
        Group floor = new Group();
        Rectangle floorStart = new Rectangle(300, 10);
        floor.setLayoutY(500);
        floor.getChildren().add(floorStart);
        
        Block block = createBlock();
        current = block;
        
        scene2.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                current.left();
            }
            
            if (event.getCode() == KeyCode.RIGHT) {
                current.right();
            }
            
            if (event.getCode() == KeyCode.DOWN) {
                current.down();
            }
            
            if(event.getCode() == KeyCode.CONTROL){
                current.rotate();
            }
            
            if(event.getCode() == KeyCode.Z){
                current.rotate();
            }
        });
        
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                
                time += 0.017;
                if (time >= 1.0) {
                    current.down();
                    time = 0;
                }
                
                if (current.collision(floor, pieces)) {
                    stop();
                    pieces.add(current);
                    Block moo = createBlock();
                    current = moo;
                    game.getChildren().add(current.getBlock());
                    this.start();
                }
            }
        }.start();
        
        window.getChildren().add(newGame);
        game.getChildren().add(block.getBlock());
        game.getChildren().add(floor);
        
        Stage.setScene(scene);
        Stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
    *Metodi luo sattumanvaraisesti jonkin uuden palan
    *
    */
    public Block createBlock() {
        Random r = new Random();
        int i = r.nextInt(7) + 1;
        if (i == 1) {
            LBlock b = new LBlock();
            return b;
        }
        
        if (i == 2) {
            Square s = new Square();
            return s;
        }
        
        if (i == 3) {
            JBlock j = new JBlock();
            return j;
        }
        
        if(i == 4){
            IBlock ib = new IBlock();
            return ib;
            
        }
        
        if(i == 5){
            SBlock sb = new SBlock();
            return sb;
        }
        
        if(i == 6){
            ZBlock z = new ZBlock();
            return z;
        }
        
        if(i == 7) {
            TBlock t = new TBlock();
            return t;
        }
        return null;
    }
    
}
