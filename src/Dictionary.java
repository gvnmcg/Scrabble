import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Timer;

public class Dictionary {

    private Trie trie = new Trie();

    Dictionary() {

        readIn("src/txt/sowpods.txt");
    }

    boolean isWord(String word){
        return trie.find(word);
    }



    void readIn(String filename){

        Scanner scanner = null;

        //read in file
        try {
            scanner= new Scanner(new FileReader(filename));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        //start timer
        long time = System.currentTimeMillis();

        //read every line into retrieval tree
        while (scanner.hasNext()){
            trie.insert(scanner.nextLine());
        }

        //print timer
        System.out.println("dictionary time: " + (System.currentTimeMillis() - time));
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
