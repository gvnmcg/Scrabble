import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Board {

    char[] spaces = new char[225];

    void placeLetter(Letter l, int x, int y){

    }

    boolean placeWord(LinkedList<Letter> word, int x, int y, int dx, int dy){

        return false;
    }

    boolean isAvailable(int x, int y){


        return true;
    }


    public static void main(String[] args) {

        //Make new board and read in text file
        Board board = new Board();

        // n rows, m columns,
        // m * 3 characters: [wsm = word_Score_multiplayer, lsm = letter_Score_multiplayer, whitespace]

        File f = new File("src\\scrabble_board.txt");

        try {



            Scanner scanner = new Scanner(f);

            while (scanner.hasNext()) {

                System.out.println(scanner.nextLine() + " wow");
            }

            scanner.close();

        }catch (Exception x){

            x.printStackTrace();
        }

    }

}
