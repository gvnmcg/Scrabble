import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Board {

    int sideLength;

    private BoardSpace[][] spaces;

    private ArrayList<BoardSpace> boardSpaceList = new ArrayList<>();

    private HashMap<BoardSpace, Letter> letterMap = new HashMap<>();



    //keep track of player move

    private LinkedList<Letter> currentMove = new LinkedList<>();
    private HashMap<Letter, BoardSpace> moveMap = new HashMap<>();


    //Display

    BoardDisplay boardDisplay;

    Board(Letter startLetter){

        readIn("src/txt/scrabble_board.txt");


    }

    void placeLetter(BoardSpace bs, Letter l){

        //TODO
        System.out.println("place " + l + " on " + bs );

        bs.setLetter(l);
        letterMap.put(bs, l);

        boardDisplay.addLetterGroup(bs, l);
    }

    /**
     * resets move
     * removes letter from board
     * clears moveMap
     *
     */
    public void resetMove() {

        for (Letter l : currentMove){

            moveMap.get(l).setLetter(null);
            moveMap.remove(l);
        }
        boardDisplay.update(letterMap);
    }

    public boolean confirmBoard(Dictionary dictionary) {

        String word = "";
        //check every "line" of letters down and across
        //every row
        for (BoardSpace[] row : spaces){
            //horizontal check
            for (BoardSpace bs : row){

                if (bs.hasLetter()){
                    word += bs.getLetter().getChar();
                } else {
                    if (!word.equals("") && word.length() > 1){
                        if (!dictionary.isWord(word)){
                            return false;
                        }
                    }
                    word = "";
                }
            }
            word = "";
        }
        BoardSpace bs;

        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {

                bs = spaces[i][j];

                if (bs.hasLetter()){
                    word += bs.getLetter().getChar();
                } else {
                    if (!word.equals("") && word.length() > 1){
                        if (!dictionary.isWord(word)){
                            return false;
                        }
                    }
                    word = "";
                }
            }
            word = "";
        }



        return true;

    }

    boolean isAvailable(int x, int y){
        return spaces[x][y].hasLetter();
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
        Board board = new Board(null);
    }



}
