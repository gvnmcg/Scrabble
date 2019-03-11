import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Scrabble Game Board
 */
public class Board {

    private int sideLength;

    private BoardSpace[][] spaces;

    private ArrayList<BoardSpace> boardSpaceList = new ArrayList<>();

    private HashMap<BoardSpace, Letter> letterMap = new HashMap<>();



    //keep track of player move

    private LinkedList<BoardSpace> currentMove = new LinkedList<>();
    private HashMap<Letter, BoardSpace> moveMap = new HashMap<>();


    //Display

    private BoardDisplay boardDisplay;

    Board(){

        readIn("src/txt/scrabble_board.txt");


    }

    void placeLetter(BoardSpace bs, Letter l){

        //add to this move - to remove later
        currentMove.add(bs);

        //add letter to data structure
        bs.setLetter(l);

        //add pair to the data stucture - to remove and check???
        letterMap.put(bs, l);

        //showLetters dislay
        if (boardDisplay != null) boardDisplay.addLetterGroup(bs, l);

    }

    /**
     * resets move
     * removes letter from board
     * clears moveMap
     *
     */
    public void resetMove() {

        for (BoardSpace bs : currentMove){
            bs.setLetter(null);
            letterMap.remove(bs);
        }


        boardDisplay.removeMove(currentMove);
        currentMove.clear();

    }

    /**
     * check every "line" of letters down and across
     * @param dictionary
     * @return
     */
    public boolean confirmBoard(Dictionary dictionary) {

        boolean confirmed = true;

        String word = "";

        // horizontal check
        for (BoardSpace[] row : spaces){
            for (BoardSpace bs : row){

                //if we hit an empty scpace AND the word is not empty
                //then I have a word
                if (bs.hasLetter()){
                    word += bs.getLetter().getChar();
                } else {

                    if (!word.equals("") && word.length() > 1){

                        //we can look it up
                        if (!dictionary.isWord(word)){
                            confirmed = false;
                        }
                    }
                    word = "";
                }
            }
            word = "";
        }
        BoardSpace bs;

        //vertical check
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {

                bs = spaces[j][i];

                if (bs.hasLetter()){
                    word += bs.getLetter().getChar();
                } else {

                    if (!word.equals("") && word.length() > 1 ){

                        if (!dictionary.isWord(word)){

                            confirmed = false;
                        }
                    }
                    word = "";
                }
            }
            word = "";
        }

        return confirmed;

    }



    public int computeMove() {

        int points = 0;

        boolean inCurrent = false;

        LinkedList<BoardSpace> playedWord = new LinkedList<>();

        // horizontal check
        for (BoardSpace[] row : spaces) {
            for (BoardSpace bs : row) {


                //if we hit a letter
                if (bs.hasLetter()){

                    //if the letter we hit has just been placed
                    if (currentMove.contains(bs)){
                        inCurrent = true;
                    }

                    //regardless, add it to the word detected
                    playedWord.add(bs);

                    //if we end a word
                } else if (!bs.hasLetter()
                        && !playedWord.isEmpty()
                        && playedWord.size() > 1){

                    //add the word that was just played
                    if (inCurrent){

                        points += computeWord(playedWord);

                    }
                    playedWord.clear();
                }
            }
        }

        //vertical check
        BoardSpace bs;
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {

                bs = spaces[j][i];

                //if we hit a letter
                if (bs.hasLetter()){

                    //if the letter we hit has just been placed
                    if (currentMove.contains(bs)){
                        inCurrent = true;
                    }

                    //regardless, add it to the word detected
                    playedWord.add(bs);

                    //if we end a word
                } else if (!bs.hasLetter()
                        && !playedWord.isEmpty()
                        && playedWord.size() > 1){

                    //add the word was just played
                    if (inCurrent){

                        points += computeWord(playedWord);

                    }
                    playedWord.clear();
                }
            }
        }

        currentMove.clear();
        return points;
    }

    private int computeWord(LinkedList<BoardSpace> playedWord) {

        int points = 0;
        //add to the score returned
        for (BoardSpace bsL : playedWord){

            points += (bsL.getLetter().getScore()
                    * bsL.getLetterScoreMultiplier());

            points *= bsL.getWordScoreMultiplier();
        }

        System.out.println("pnts : " + points);

        System.out.println("word : " + playedWord);

        return points;

    }

    BoardSpace getBoardSpace(int x, int y){
        return spaces[x][y];
    }

    /**
     * Scan file and load board data into data structure
     *
     * save board size
     * n rows, n columns, nxn
     *
     * each piece of board data is n * 3 characters:
     * [wsm = word_Score_multiplayer, lsm = letter_Score_multiplayer, whitespace]
     *
     * @param filename
     */
    void readIn(String filename){

        //using two scanners
        //one to grab lines
        Scanner fileSc = null;
        //one to grab chunks from the line
        Scanner lineSc;

        //keep track of board location
        int row = 0;
        int col = 0;

        try {
            fileSc = new Scanner(new File(filename));

            //first line, the length of the sides (n) of the cubed board
            sideLength = Integer.parseInt(fileSc.nextLine());
            //use n to init data structure
            spaces = new BoardSpace[sideLength][sideLength];

            //read into data structure
            while (fileSc.hasNext()) {

                lineSc = new Scanner(fileSc.nextLine());
                while (lineSc.hasNext()){
                    spaces[row][col] = new BoardSpace(lineSc.next());
                    col++;
                }
                col = 0;
                row++;
            }

        }catch (Exception x){
            x.printStackTrace();
        } finally {
            fileSc.close();
        }

    }




    public void setBoardDisplay(BoardDisplay boardDisplay) {
        this.boardDisplay = boardDisplay;
    }


    @Override
    public String toString() {

        String rep = "";
        for (BoardSpace[] row : spaces){
            for (BoardSpace bs : row){
                rep += bs.toString() + " ";
            }
            rep += "\n";
        }

        return rep;
    }

    public static void main(String[] args) {

        //Make new board and read in text file
        Board board = new Board();
    }



}
