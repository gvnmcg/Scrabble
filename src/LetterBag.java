import java.util.LinkedList;
import java.util.Scanner;

public class LetterBag {

    LinkedList<Letter> letters = new LinkedList<>();

    LetterBag(){

        createAllLetters();

        for (Letter l : letters){

            System.out.printf("%c , %d", l.c, l.score);
        }
    }

    void createAllLetters(){


        Scanner sc = new Scanner("scabble_tiles.txt");

        while (sc.hasNext()){

        }
    }

    void createLetters(char c, int score, int dup){

        letters.add(new Letter(c, score));

        if (dup == 0) return;
        else createLetters( c, score, dup--);
    }

    Letter draw(){

        return null;
    }

    public static void main(String[] args) {
        new LetterBag();
    }
}
