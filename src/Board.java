import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Board {

    int sideLength;

    WordSpace[] spaces;

    ArrayList<WordSpace> spaceArrayList;

    Board(String filename){

        readIn(filename);

    }

    void placeLetter(Letter l, int x, int y){

    }

    boolean placeWord(LinkedList<Letter> word, int x, int y, int dx, int dy){

        return false;
    }

    boolean isAvailable(int x, int y){


        return true;
    }

    void readIn(String filename){


        //scan file
        //first line, the length of the sides (n) of the cubed board
        //each line after is n pairs of characters
        try {

            Scanner scanner = new Scanner(new File("src/txt/scrabble_board.txt"));

            sideLength = scanner.nextInt();


            while (scanner.hasNext()) {

                spaceArrayList.add(new WordSpace(scanner.next()));
                System.out.println(scanner.nextLine() + " wow");
            }

            scanner.close();

        }catch (Exception x){

            x.printStackTrace();
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
