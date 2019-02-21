import java.util.LinkedList;
import java.util.Scanner;

public class LetterBag {

    LinkedList<Letter> letters = new LinkedList<>();

    LetterBag(){

        createAllLetters();
    }

    void createAllLetters(){


        Scanner sc = new Scanner();

        while (sc.hasNext()){

            letters.add(new Letter(sc.nextLine()));
        }
    }

    Letter draw(){

    }
}
