package TetrisUI;

import Blocks.Square;
import java.util.HashMap;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class TetrisUI extends Application {

    private double time;
    private Square current;

    @Override
    public void start(Stage Stage) throws Exception {
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

        Line floor = new Line();
        floor.setStartX(0.0);
        floor.setStartY(400.0);
        floor.setEndX(300.0);
        floor.setEndY(400.0);

        Square square = new Square();
        current = square;


        scene2.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                current.left();
            }

            if (event.getCode() == KeyCode.RIGHT) {
                current.right();
            }
            
            if(event.getCode() == KeyCode.DOWN) {
                current.down();
            }
        });

        new AnimationTimer() {
            @Override
            public void handle(long now) {

                time += 0.017;
                if (time >= 1.0) {
                    current.move();
                    time = 0;
                }

                if (current.collision(floor)) {
                    stop();
                    Square moo = new Square();
                    current = moo;
                    game.getChildren().add(current.getSquare());
                    this.start();
                }
            }
        }.start();

        window.getChildren().add(newGame);
        game.getChildren().add(square.getSquare());
        game.getChildren().add(floor);

        Stage.setScene(scene);
        Stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
