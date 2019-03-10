import java.util.LinkedList;

/**
 * https://www.baeldung.com/trie-java
 */
public class Trie {

    private TrieNode root = new TrieNode();
    //...

    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            current = current.getChildren()
                    .computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public boolean find(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);


            if (ch == '*'){

                return find(word.substring(i), current);
            }

            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    /**
     * The method I wrote to recursively fill in blanks
     * @param word
     * @return
     */
    boolean findRec(String word){
        return find(word, root);
    }

    /**
     * The method I wrote to recursively fill in blanks
     * @param word
     * @param node
     * @return
     */
    public boolean find(String word, TrieNode node){

        char ch = word.charAt(0);

        if (ch == '*'){

            for (char blankChar : node.getChildren().keySet()){

                word = blankChar + word.substring(1);

                if ( find(word, node) ){
                    return true;
                }
            }
            return false;
        }

        TrieNode current = node.getChildren().get(ch);

        if ( current == null ){
            return  false;
        }

        if ( current.isEndOfWord()){
            return true;
        }

        if (word.length() == 1){
            return find(word, current);
        }

        return find(word.substring(1), current);

    }

    /**
     *
     * This alghorithm searches the dictionary for leters to include in a word
     * which already is given a few letters determined by multipliersa and previous words
     *
     * @param result - how we keep track of the word
     * @param word - the word, including the blanks
     * @param tray - the possible words we can use
     * @param node - the next node for the next letter
     * @return a word froun in our dictionary
     */
    String findPossibleWord(String result, String word, LinkedList<Character> tray, TrieNode node){

        if (node == null) node = root;

        char ch = word.charAt(0);
        TrieNode current = node.getChildren().get(ch);

        if ( current == null ){
            return "";
        }

        //leaving lots of blanks
        if (ch == '*'){
            //look through possible next chars
            for (char blankChar : node.getChildren().keySet()){

                word = blankChar + word.substring(1);

                //next chars that we can use
                if (tray.contains(blankChar)){
                    //we have used this letter
                    tray.remove(blankChar);
                    current = node.getChildren().get(blankChar);

                    //it may return a completed word
                    if( !((blankChar + findPossibleWord(result + blankChar,
                            word.substring(1),tray, current)).equals(""))){

                        return blankChar + findPossibleWord(result + blankChar,
                                word.substring(1),tray, current);
                    }
                }
            }
            return "";
        }

        current = node.getChildren().get(ch);

        if (current.isEndOfWord()){
            return result;
        }

        return result + ch + findPossibleWord(result + ch,
                word.substring(1),
                tray,
                current);

    }

    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();


        System.out.println("apple : " + dictionary.isWord("apple"));
        System.out.println("ap*le : " + dictionary.isWord("ap*le"));

    }
}
