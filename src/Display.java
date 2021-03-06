import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.HashMap;

/**
 * Manages Display and Display Components
 */
public class Display {

    //Display helper objects

    private BorderPane layout = new BorderPane();

    private Controller controller;

    private DisplayComponents components;


    //settings

    final static int WIDTH = 1000;
    final static int HEIGHT = 700;

    int LEFT_MARGIN = 10;
    int TOP_MARGIN = 20;

    private int scale = 30;


    //display Game Objects

    private BoardDisplay boardDisplay;
    private PlayerDisplay currentPlayerDisplay;

    private HashMap<Player, PlayerDisplay> playerDisplayMap = new HashMap<>();
    private HashMap<Letter, Group> letterGroupMap = new HashMap<>();

    Display(){

        components = new DisplayComponents(scale);

    }

    public void setController(Controller controller) {
        this.controller = controller;

        //add reset and comfirm buttons

        VBox rightButtonVbox = new VBox();
        rightButtonVbox.setAlignment(Pos.CENTER);
        rightButtonVbox.setSpacing(100);

        //reset button
        rightButtonVbox.getChildren().add(resetButton(controller));

        //confirm button
        rightButtonVbox.getChildren().add(confirmButton(controller));

        //exchange button
        rightButtonVbox.getChildren().add(exchangeButton(controller));

        layout.setRight(rightButtonVbox);
    }

    /**
     * sets this board display
     * sets board componenst to center node
     * returns the new board display to manager/board object
     * @param board
     * @return
     */
    BoardDisplay makeBoardDisplay(Board board){
        boardDisplay = new BoardDisplay(board, controller);
        layout.setCenter(boardDisplay.getRoot());
        return boardDisplay;
    }

    /**
     * adds this player display to map of player displays
     *
     * @param player
     * @return
     */
    PlayerDisplay makePlayerDisplay(Player player){
        PlayerDisplay playerDisplay = new PlayerDisplay(player, controller);
        playerDisplayMap.put(player, playerDisplay);

        return playerDisplay;
    }

    void setCurrentPlayerDisplay(Player player){
        currentPlayerDisplay = playerDisplayMap.get(player);
        layout.setBottom(currentPlayerDisplay.getRoot());

    }

    Button resetButton(Controller controller){
        Button resetButton = new Button("Reset");
        resetButton.setStyle("-fx-text-fill: #006464;\n" +
                "    -fx-background-color: #DFB951;\n" +
                "    -fx-border-radius: 20;\n" +
                "    -fx-background-radius: 20;\n" +
                "    -fx-padding: 5;");
        resetButton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                controller.handleReset());

        return resetButton;
    }

    Button confirmButton(Controller controller){

        Button confirmButton = new Button("Confirm");
        confirmButton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                controller.handleConfirm());

        confirmButton.setStyle("-fx-text-fill: #006464;\n" +
                "    -fx-background-color: #DFB951;\n" +
                "    -fx-border-radius: 20;\n" +
                "    -fx-background-radius: 20;\n" +
                "    -fx-padding: 5;");
        return confirmButton;
    }

    Button exchangeButton(Controller controller){

        Button exchangeButton = new Button("Exchange");
        exchangeButton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                controller.handleExchange());

        exchangeButton.setStyle("-fx-text-fill: #006464;\n" +
                "    -fx-background-color: #DFB951;\n" +
                "    -fx-border-radius: 20;\n" +
                "    -fx-background-radius: 20;\n" +
                "    -fx-padding: 5;");
        return exchangeButton;
    }



    public BorderPane getLayout() {
        return layout;
    }

    public void setGameInfo(Scrabble scrabble) {

        VBox vBox = new VBox();

        for (Player p : scrabble.getPlayers()){
            vBox.getChildren().add(DisplayComponents.makePlayerGroup(p));
        }

        layout.setLeft(vBox);

        layout.setTop(scrabble.getText());
    }

    Scene getScene(){
        return new Scene(layout, WIDTH, HEIGHT);
    }
}
