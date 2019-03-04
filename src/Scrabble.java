import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.LinkedList;
import java.util.Random;

public class Scrabble {

    Player currentPlayer;
    int index;
    LinkedList<Player> players = new LinkedList<>();

    //Display
    Text text = new Text();


    Player startGame(){
        return currentPlayer =
                players.get(
                        new Random().nextInt(players.size()));
    }

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

    HBox topBox(){
        HBox hBox = new HBox();

        hBox.getChildren().add(text);
        return hBox;
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public Text getText() {
        return text;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
