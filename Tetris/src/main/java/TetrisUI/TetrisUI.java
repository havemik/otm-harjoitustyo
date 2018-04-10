package TetrisUI;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TetrisUI extends Application {

    @Override
    public void start(Stage Stage) throws Exception {
        Stage.setTitle("Tetris");
        Pane window = new Pane();
        Scene scene = new Scene(window, 500, 500);
        
        Pane game = new Pane();
        game.setPrefSize(100, 500);
        
        Rectangle block = new Rectangle(20, 20);
        block.setTranslateX(50);
        
        Scene scene2 = new Scene(game, 300, 600);
        
        Button newGame = new Button("New Game");
        newGame.setOnAction(e -> {
            Stage.setScene(scene2);
        });
        
        window.getChildren().add(newGame);
        game.getChildren().add(block);
        
        Stage.setScene(scene);
        Stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
