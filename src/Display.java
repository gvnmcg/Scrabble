import javafx.scene.Group;
import javafx.scene.layout.BorderPane;

import java.util.HashMap;

public class Display {

    //Display helper objects

    BorderPane layout = new BorderPane();

    private Controller controller;

    DisplayComponents components;

    BoardDisplay boardDisplay;

    PlayerDisplay playerDisplay;


    //settings

    final static int WIDTH = 1500;
    final static int HEIGHT = 1000;

    int LEFT_MARGIN = 10;
    int TOP_MARGIN = 20;

    int scale = 30;


    //display Game Objects

    BoardDisplay boardDisplay;
    TrayDisplay trayDisplay;
    PlayerDisplay currentPlayerDisplay;

    HashMap<Player, PlayerDisplay> playerDisplayMap = new HashMap<>();


    HashMap<Integer, Group> letterGroupMap = new HashMap<>();

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

}
