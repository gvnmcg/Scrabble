import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Board {

    int sideLength;

    BoardSpace[][] spaces;

    ArrayList<BoardSpace> boardSpaceList = new ArrayList<>();

    HashMap<BoardSpace, Letter> wordSpaceLetterMap = new HashMap<>();

    Dictionary dictionary = new Dictionary();

    Display display;

    BoardDisplay boardDisplay;

    Board(Display display){
        this.display = display;

        boardDisplay = display.makeBoardDisplay();
    }

    Board(String filename){

        readIn(filename);

    }

    Board(){

        readIn("src/txt/scrabble_board.txt");

    }


    void placeLetter(Letter l, int x, int y){

        BoardSpace ws = boardSpaceList.get( (y*sideLength) + x );

        wordSpaceLetterMap.put(ws, l);
    }

    boolean placeWord(LinkedList<Letter> word, int x, int y, int dx, int dy){

        return false;
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

    void printBoard(){

        for (BoardSpace[] row : spaces){
            for (BoardSpace bs : row){
                System.out.print(bs + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        //Make new board and read in text file
        Board board = new Board();
        board.printBoard();

        // n rows, n columns, nxn
        // n * 3 characters: [wsm = word_Score_multiplayer, lsm = letter_Score_multiplayer, whitespace]
    }

}
