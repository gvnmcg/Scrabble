import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class LetterBag {

    LinkedList<Letter> letters = new LinkedList<>();

    LetterBag() {

    }

    void createAllLetters() throws FileNotFoundException {


        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("src/txt/scrabble_tiles.txt"));
        } catch (FileNotFoundException e){

            e.printStackTrace();
        }

        //every line is character, score value, duplicates
        while (sc.hasNext()){

            Character c = sc.next().charAt(0);
            int points = Integer.parseInt(sc.next());
            int dup = Integer.parseInt(sc.next());

            createLetter(c, points, dup);

        }
    }

    void createLetter(char c, int score, int dup){

        letters.add(new Letter(c, score));

        if (dup == 1) return;
        else createLetter( c, score, --dup);
    }

    Letter draw(){

        Random random = new Random();

        return letters.remove(random.nextInt(letters.size()));
    }

    void printAll(){

        for (Letter l : letters){

            System.out.println(l);
        }
    }

    public static void main(String[] args)  throws FileNotFoundException {

        LetterBag lb = new LetterBag();
        lb.createAllLetters();

        lb.printAll();

        System.out.println(lb.draw());
        System.out.println(lb.draw());
        System.out.println(lb.draw());
        System.out.println(lb.draw());


    }
}
