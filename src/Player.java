import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.LinkedList;

public class Player {

    LinkedList<Letter> trayList = new LinkedList<>();

    //display components

    PlayerDisplay playerDisplay;

    Player(Board board, LetterBag bag){

        for (int i = 0; i < 7; i++) {
            trayList.add(bag.draw());
        }

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


    public LinkedList<Letter> getTrayList() {
        return trayList;
    }

}
