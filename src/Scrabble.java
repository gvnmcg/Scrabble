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
//            return players.iterator().next();
//        } else {
//            return players.get(0);
//        }

        Player p = players.pop();
        players.addLast(p);

        System.out.println(" next : " + p.getName());
        return players.getFirst();
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
