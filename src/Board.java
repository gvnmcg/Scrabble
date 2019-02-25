import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Board {

    int sideLength;

    WordSpace[] spaces;

    ArrayList<WordSpace> wordSpaceList = new ArrayList<>();

    HashMap<WordSpace, Letter> wordSpaceLetterMap = new HashMap<>();

    Board(String filename){

        readIn(filename);

    }

    void placeLetter(Letter l, int x, int y){

        WordSpace ws = wordSpaceList.get( (y*sideLength) + x );

        wordSpaceLetterMap.put(ws, l);
    }

    boolean placeWord(LinkedList<Letter> word, int x, int y, int dx, int dy){

        return false;
    }

    boolean isAvailable(int x, int y){


        return true;
    }

    void readIn(String filename){


        //scan file
        try {

            Scanner scanner = new Scanner(new File(filename));

            //first line, the length of the sides (n) of the cubed board
            sideLength = scanner.nextInt();

            //each line after is n pairs of characters
            while (scanner.hasNext()) {

                wordSpaceList.add(new WordSpace(scanner.next()));
            }
            System.out.println("The board: " + wordSpaceList);

            scanner.close();

        }catch (Exception x){

            x.printStackTrace();
        }

    }

    public static void main(String[] args) {

        //Make new board and read in text file
        Board board = new Board("src/txt/scrabble_board.txt");

        // n rows, n columns, nxn
        // n * 3 characters: [wsm = word_Score_multiplayer, lsm = letter_Score_multiplayer, whitespace]

//        File f = new File("src/txt/scrabble_board.txt");



    }

}
