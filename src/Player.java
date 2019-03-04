import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player {

    private LinkedList<Letter> trayList = new LinkedList<>();

    private int score;

    private String name;

    //used to make moves

    private Letter selectedLetter;

    private LinkedList<Letter> currentMove = new LinkedList<>();
    private ArrayList<Pair<String, Integer>> moves = new ArrayList<>();

    //display components

    PlayerDisplay playerDisplay;

    Player(Board board, LetterBag bag){

        for (int i = 0; i < 7; i++) {
            trayList.add(bag.draw());
        }

        score = 0;

    }


    /**
     * rearranges letter
     * updates display
     *
     * @param selectedLetter
     */
    public void setSelectedLetter(Letter selectedLetter) {

        this.selectedLetter = selectedLetter;

        if (trayList.contains(selectedLetter)){
            trayList.remove(selectedLetter);
            trayList.add(selectedLetter);

            playerDisplay.showLetters(getTray());
        }
    }

    /**
     * remove form tray
     * add to currentmove
     * update display
     * @return
     */
    public Letter removeSelectedLetter() {

        currentMove.add(selectedLetter);
        trayList.remove(selectedLetter);
        playerDisplay.showLetters(getTray());

        return selectedLetter;
    }

    /**
     * add the current move back into tray
     * clear current move
     * update Display
     */
    public void resetMove() {

        trayList.addAll(currentMove);
        currentMove.clear();
        playerDisplay.showLetters(trayList);

    }

    /**
     *
     * @param bag
     */
    void refillTray(LetterBag bag){

        while (trayList.size() < 7 && !bag.isEmpty()){
            trayList.add(bag.draw());
        }
        playerDisplay.showLetters(getTray());
    }


    public void setPlayerDisplay(PlayerDisplay playerDisplay) {
        this.playerDisplay = playerDisplay;
    }

    public LinkedList<Letter> getTray() {
        return trayList;
    }

    public Letter getSelectedLetter() {
        return selectedLetter;
    }

    public LinkedList<Letter> getCurrentMove() {
        return currentMove;
    }

    public void addPoints(int computedMove) {
        score += computedMove;
    }

    public void confirmWord() {
        //TODO
        currentMove.clear();
    }

    public String getName() {

        return name;
    }

    public int getScore() {
        return score;
    }
}
