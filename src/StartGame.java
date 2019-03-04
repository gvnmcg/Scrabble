import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.LinkedList;

public class StartGame {

    Stage window;

    Scene titleScene;

    Scene playerScene;

    Scene gameScene;

    Scrabble scrabble;

    StartGame(Manager manager, Scrabble scrabble, Stage window, Scene gameScene ){
        this.scrabble = scrabble;
        this.window = window;

        this.gameScene = gameScene;

        titleScene = getTitleScene(manager);

        window.setScene(titleScene);


    }

    public Scene getTitleScene(Manager manager) {


        StackPane pane = new StackPane();
        pane.getChildren().add(new Text("Scrabble"));
        pane.getChildren().add(new Text("by Gavin McGuire"));

        Button playButton = new Button("Play");
        playButton.setOnAction(event -> {
            window.setScene(getPlayerScene(manager));
        });

        pane.getChildren().add(playButton);

        return titleScene = new Scene(pane, Display.WIDTH, Display.HEIGHT );
    }

    public Scene getPlayerScene(Manager manager) {

        StackPane pane = new StackPane();
        pane.getChildren().add(new Text("Enter Player"));
        TextField textField = new TextField("...");
        pane.getChildren().add(textField);

        Button enterPlayer = new Button("enter player");
        enterPlayer.setOnAction(event -> {

            scrabble.addPlayer(new Player(textField.getText()));
            textField.clear();
        });

        pane.getChildren().add(enterPlayer);


        Button playButton = new Button("Play");
        playButton.setOnAction(event -> {

            if (scrabble.getPlayers().isEmpty()){
                scrabble.addPlayer(new Player("???"));
                scrabble.addPlayer(new ComputerPlayer("cpu"));
            }
            window.setScene(gameScene);

            manager.startGame(scrabble);
        });

        pane.getChildren().add(playButton);

        return playerScene = new Scene(pane, Display.WIDTH, Display.HEIGHT );
    }
}
