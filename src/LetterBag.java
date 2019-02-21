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

            letters.add(new Letter(sc.nextLine()));
        }
    }

    Letter draw(){

    }
}
