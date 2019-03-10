import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartGame {

    private Stage window;

    private Scrabble scrabble;

    StartGame(Scrabble scrabble, Manager manager, Stage window, Display display ){
        this.scrabble = scrabble;
        this.window = window;

        window.setScene(getTitleScene(manager, display));
    }

    /**
     * Make the first scene in the program
     * @param manager
     * @param display
     * @return
     */
    private Scene getTitleScene(Manager manager, Display display) {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        //Title

        Text t = new Text("Scrabble");
        t.setFont(Font.font(40));
        pane.add(t, 0, 1);

        t = new Text("by Gavin McGuire");
        t.setFont(Font.font(20));
        pane.add(t, 0, 2);

        //Play Button
        Button playButton = new Button("Play");
        playButton.setOnAction(event -> {
            window.setScene(getPlayerScene(manager, display));
        });
        pane.add(playButton, 0, 3);

        return new Scene(pane, Display.WIDTH, Display.HEIGHT );
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

        VBox playerVBox = new VBox();
        borderPane.setLeft(playerVBox);

        Button enterPlayer = new Button("enter player");

        CheckBox cpuCheckBox = new CheckBox();
        grid.add(new Text("cpu?"), 1, 2);
        grid.add(cpuCheckBox, 2, 2);

        enterPlayer.setOnAction(event -> {
            Player p;
            if (cpuCheckBox.isSelected()){
                p = new ComputerPlayer(textField.getText());
                textField.clear();
            } else {
                p = new Player(textField.getText());
                textField.clear();
            }

            //add to Game
            scrabble.addPlayer(p);

            //add to vBox
            playerVBox.getChildren().add(DisplayComponents.makePlayerGroup(p));
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


        return new Scene(borderPane, Display.WIDTH, Display.HEIGHT );
    }


}
