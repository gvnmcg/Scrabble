import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Board {

    static int sideLength;

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

    void readIn(String filename){

        //scan file
        Scanner fileSc = null;
        Scanner lineSc;

        int row = 0;
        int col = 0;

        try {

            fileSc = new Scanner(new File(filename));

            //first line, the length of the sides (n) of the cubed board
            sideLength = Integer.parseInt(fileSc.nextLine());

            spaces = new BoardSpace[sideLength][sideLength];

            //each line after is n pairs of characters
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

        printBoard();
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

        // n rows, n columns, nxn
        // n * 3 characters: [wsm = word_Score_multiplayer, lsm = letter_Score_multiplayer, whitespace]

//        File f = new File("src/txt/scrabble_board.txt");



    }

}
