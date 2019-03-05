import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;

import java.util.LinkedList;

public class StartGame {

    Stage window;

    Scene titleScene;

    Scene playerScene;

    Scene gameScene;

    Scrabble scrabble;

    StartGame(Scrabble scrabble, Manager manager,  Stage window, Display display ){
        this.scrabble = scrabble;
        this.window = window;

        window.setScene(titleScene = getTitleScene(manager, display));
    }

    private Scene getTitleScene(Manager manager, Display display) {

        //Title
        StackPane pane = new StackPane();
        pane.getChildren().add(new Text("Scrabble"));
        pane.getChildren().add(new Text("by Gavin McGuire"));

        //Play Button
        Button playButton = new Button("Play");
        playButton.setOnAction(event -> {
            window.setScene(getPlayerScene(manager, display));
        });
        pane.getChildren().add(playButton);

        return titleScene = new Scene(pane, Display.WIDTH, Display.HEIGHT );
    }

    public Scene getPlayerScene(Manager manager, Display display) {

        //Player naming scene

        //left contains all players info
        //center contains input
        BorderPane borderPane = new BorderPane();

        //input Pane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        borderPane.setCenter(grid);

        //where to enter names of players
        grid.add(new Text("Enter Player"), 0 ,1);
        TextField textField;
        grid.add(textField = new TextField("..."), 0 , 2);



        //makes a new player fomr text field
        Button enterPlayer = new Button("enter player");
        enterPlayer.setOnAction(event -> {

            Player p = new Player(textField.getText());
            textField.clear();

            //add to Game
            scrabble.addPlayer(p);
        });
        grid.add(enterPlayer, 0, 3);

        //exit scene and start gameplay
        Button playButton = new Button("Play");
        playButton.setOnAction(event -> {

            //if no players entered, you are "???"
            //and your opponent is a computer
            if (scrabble.getPlayers().isEmpty()){
                scrabble.addPlayer(new Player("???"));
                scrabble.addPlayer(new ComputerPlayer("cpu"));
            }
            //start game logic
            manager.startGame(scrabble);

            //give players display components
            manager.setDisplay(display);

            //change scene
            window.setScene(display.getScene());
        });
        grid.add(playButton, 0, 4);


        return playerScene = new Scene(borderPane, Display.WIDTH, Display.HEIGHT );
    }


}
