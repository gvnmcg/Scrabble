import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.LinkedList;

public class Player {

    private Tray tray;

    LinkedList<Letter> trayList = new LinkedList<>();

    //display components

    PlayerDisplay playerDisplay;

    Player(Board board, LetterBag bag){

        tray = new Tray(bag);
    }

    Letter getSelectedLetter(){
        return tray.selected;
    }


    boolean placeLetter(Letter l, int x, int y){

        return true;
    }

    boolean placeWord(LinkedList<Letter> word, int x, int y){

        return true;
    }

    public void setPlayerDisplay(PlayerDisplay playerDisplay) {
        this.playerDisplay = playerDisplay;
    }

    public Tray getTray() {
        return tray;
    }

    public LinkedList<Letter> getTrayList() {
        return trayList;
    }

}
