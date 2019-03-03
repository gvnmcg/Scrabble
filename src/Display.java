import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public class Display {

    //Display helper objects

    private BorderPane layout = new BorderPane();

    private Controller controller;

    private DisplayComponents components;


    //settings

    final static int WIDTH = 700;
    final static int HEIGHT = 700;

    int LEFT_MARGIN = 10;
    int TOP_MARGIN = 20;

    int scale = 30;


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

    public BorderPane getLayout() {
        return layout;
    }
}
