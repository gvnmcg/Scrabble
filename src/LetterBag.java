import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class LetterBag {

    LinkedList<Letter> letters = new LinkedList<>();

    LetterBag() {
        createAllLetters();
    }

    /**
     * fill data structure letters with new objects specified
     * by the text file
     * @throws FileNotFoundException
     */
    void createAllLetters()  {

        //scan letters, points and distribution form a text file
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/txt/scrabble_tiles.txt"));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        //add eachnew letter to out letterBag data structure
        //every line is character, score value, duplicates
        while (sc.hasNext()){

            Character c = sc.next().charAt(0);
            int points = Integer.parseInt(sc.next());
            int dup = Integer.parseInt(sc.next());

            createLetter(c, points, dup);

        }
    }

    /**
     * create new letter
     * if there are duplicates, the function is recursively called
     * adding until no more duplicated needed
     * @param c - letter character, *'s are blank
     * @param score - point value for each letter
     * @param dup - number of dupliactes to add to the bag
     */
    void createLetter(char c, int score, int dup){

        letters.add(new Letter(c, score));

        if (dup == 1) return;
        else createLetter( c, score, --dup);
    }

    /**
     * @return a random letter from bag
     */
    Letter draw(){

        Random random = new Random();
        return letters.remove(random.nextInt(letters.size()));
    }

    /**
     * print all letters, for test purposes
     */
    void printAll(){
        for (Letter l : letters){
            System.out.println(l);
        }
    }

    /**
     * Test Letter bags
     * @param args - filename for text file
     * @throws FileNotFoundException
     */
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
