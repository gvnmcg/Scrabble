import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Timer;

/**
 * Confirms words used in the game
 */
public class Dictionary {

    private Trie trie = new Trie();

    Dictionary() {

        readIn("src/txt/sowpods.txt");
    }

    boolean isWord(String word){
        return trie.findRec(word);
//        return trie.find(word);
    }



    LinkedList<Letter> findWordFromTray(LinkedList<Letter> tray, LinkedList<BoardSpace> option){

        //ok
        //this things looks at the options:

        String word = "";
        for (BoardSpace bs : option){

            if (bs.hasLetter()){
                word += bs.getLetter().getChar();

            } else {

                if (bs.getLetterScoreMultiplier() > 1){

                    Letter bigL = tray.getFirst();
                    for (Letter l : tray){
                        if (l.getScore() > bigL.getScore()){
                            bigL = l;
                        }
                    }
                    word += bigL.getChar();

                } else {
                    word += '*';
                }
            }
        }

        //prepare for trie method
        LinkedList<Character> charTray = new LinkedList<>();
        for (Letter l : tray){
            charTray.add(l.getChar());
        }

        long time = System.currentTimeMillis();

        word = trie.findPossibleWord("", word, charTray, null);

        //reorganize to a list of letters
        for (int i = 0; i < word.length(); i++) {

            for (Letter l : tray){
                if (word.charAt(i) == l.getChar()){
                    tray.remove(l);
                    tray.add(l);
                    break;
                }
            }
        }

        return tray;
    }



    void readIn(String filename){

        Scanner scanner = null;

        //read in file
        try {
            scanner= new Scanner(new FileReader(filename));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }


        //read every line into retrieval tree
        while (scanner.hasNext()){
            trie.insert(scanner.nextLine());
        }

    }

    public static void main(String[] args)  {


        //args = [ dictionary_filename ... ]

        //create Dictionary and read in the textfile

        Dictionary dictionary = new Dictionary();
        dictionary.readIn(args[0]);

        // test if the text file is stored and retrievable
        //names are not retrivable
        System.out.println("found word: " + dictionary.trie.find("abase"));
        System.out.println("found word: " + dictionary.trie.find("cat"));
        System.out.println("found word: " + dictionary.trie.find("bat"));
        System.out.println("found word: " + dictionary.trie.find("hal"));
        System.out.println("found word: " + dictionary.trie.find("abase"));
        System.out.println("found word: " + dictionary.trie.find("abase"));


    }
}
