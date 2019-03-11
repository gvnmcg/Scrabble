import javafx.scene.text.Text;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Represents the Player of the game
 */
public class Player {

    private LinkedList<Letter> trayList = new LinkedList<>();

    private int score = 0;
    private Text scoreText;

    private String name;

    //used to make moves

    private Letter selectedLetter;

    private LinkedList<Letter> currentMove = new LinkedList<>();
    private ArrayList<Pair<String, Integer>> moves = new ArrayList<>();

    //display components

    PlayerDisplay playerDisplay;


    Player(String name){

        this.name = name;
    }


    public void setTrayList(LetterBag bag) {
        for (int i = 0; i < 7; i++) {
            trayList.add(bag.draw());
        }
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
     *  move selected Letter to a list , player.currentMove
     *  put letter on board
     * @param bs selected board space
     * @param board - to place on board
     */
    public void placeLetter(BoardSpace bs, Board board) {

        //must have letter
        if (selectedLetter == null) return;

        //can I replace this letter?
        if (bs.hasLetter()){
            if (currentMove.contains(bs.getLetter())){
                trayList.add(bs.getLetter());
                bs.setLetter(null);
            } else {
                return;
            }
        }

        //add to move
        currentMove.add(selectedLetter);
        //remove from tray
        trayList.remove(selectedLetter);
        //update tray
        playerDisplay.showLetters(getTray());

        //put on board
        board.placeLetter(bs, selectedLetter);
        selectedLetter = null;

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
     * refill tray from bag
     * @param bag
     */
    void refillTray(LetterBag bag){

        Letter l;
        while (trayList.size() < 7 && !bag.isEmpty()){
            l = bag.draw();

            if (l == null) trayList.add(l);

        }
        playerDisplay.showLetters(getTray());
    }


    public void addPoints(int computedMove) {
        score += computedMove;
        scoreText.setText(String.valueOf(score));
    }

    public void exchange(LetterBag bag) {

        bag.takeExchange(trayList);
        trayList.clear();
        setTrayList(bag);
        playerDisplay.showLetters(trayList);
    }

    public void setPlayerDisplay(PlayerDisplay playerDisplay) {
        this.playerDisplay = playerDisplay;
    }

    public LinkedList<Letter> getTray() {
        return trayList;
    }

    public LinkedList<Letter> getCurrentMove() {
        return currentMove;
    }


    public void confirmWord() {
        currentMove.clear();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Text getScoreText() {
        return scoreText;
    }

    public void setScoreText() {
        this.scoreText  = new Text(String.valueOf(score));
    }


}
