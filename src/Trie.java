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

    boolean findRec(String word){
        return find(word, root);
    }

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

        return find(word.substring(1), current);

    }

    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();


        System.out.println("apple : " + dictionary.isWord("apple"));
        System.out.println("ap*le : " + dictionary.isWord("ap*le"));

    }
}
