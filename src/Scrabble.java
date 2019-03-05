import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.LinkedList;
import java.util.Random;

public class Scrabble {

    LinkedList<Player> players = new LinkedList<>();

    //Display
    Text text = new Text();

    VBox playerVbox;

    //----------

    Player nextPlayer(Player player){

//        if (players.iterator().hasNext()){
//            return currentPlayer = players.iterator().next();
//        } else {
//            return currentPlayer = players.get(0);
//        }

        Player p = players.pop();

        players.addFirst(p);
        return p;
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public Text getText() {
        return text;
    }

    public void setText(String str) {
        this.text.setText(str);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

}
