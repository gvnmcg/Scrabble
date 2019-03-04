import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player {

    private LinkedList<Letter> trayList = new LinkedList<>();

    int score;

    //used to make moves

    private Letter selectedLetter;

    private LinkedList<Letter> currentMove = new LinkedList<>();
    private ArrayList<LinkedList> moves = new ArrayList<>();

    //display components

    PlayerDisplay playerDisplay;

    Player(Board board, LetterBag bag){

        for (int i = 0; i < 7; i++) {
            trayList.add(bag.draw());
        }

        score = 0;

    }


    /**
     *
     *
     * @param selectedLetter
     */
    public void setSelectedLetter(Letter selectedLetter) {
        this.selectedLetter = selectedLetter;

        if (trayList.contains(selectedLetter)){
            trayList.remove(selectedLetter);
            trayList.add(selectedLetter);
            playerDisplay.update(getTrayList());
        }

    }

    public Letter removeSelectedLetter() {
        trayList.remove(selectedLetter);
        playerDisplay.update(trayList);
        return selectedLetter;
    }

    public void resetMove() {

        trayList.addAll(currentMove);
        playerDisplay.update(trayList);
    }

    void refillTray(LetterBag bag){

        while (trayList.size() < 7 && !bag.isEmpty()){
            trayList.add(bag.draw());
        }
    }


    public void confirmWord() {

        //TODO
        updateScore();

        //add move to moves
        moves.add(currentMove);
        currentMove = new LinkedList<>();
    }

    private void updateScore() {
        //TODO
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
