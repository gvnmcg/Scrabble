import java.util.HashMap;
import java.util.Map;

/**
 * https://www.baeldung.com/trie-java
 */
public class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap<>();
    private String content;
    private boolean isWord;

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setEndOfWord(boolean b) {
        isWord = b;
    }

    public boolean isEndOfWord() {
        return isWord;
    }

    // ...
}
