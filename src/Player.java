import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.LinkedList;

public class Player {

    private LinkedList<Letter> trayList = new LinkedList<>();

    private Letter selectedLetter;

    //display components

    PlayerDisplay playerDisplay;

    Player(Board board, LetterBag bag){

        for (int i = 0; i < 7; i++) {
            trayList.add(bag.draw());
        }

    }

    public void setSelectedLetter(Letter selectedLetter) {
        this.selectedLetter = selectedLetter;

        if (trayList.contains(selectedLetter)){
            trayList.remove(selectedLetter);
            trayList.add(selectedLetter);
        }

        playerDisplay.update(getTrayList());
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

    public Letter getSelectedLetter() {
        return selectedLetter;
    }
}
