import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.LinkedList;
import java.util.Random;

public class Scrabble {

    Player currentPlayer;
    int index;
    LinkedList<Player> players;

    LetterBag letterBag;

    //Display
    Text text = new Text();

    Scrabble(LinkedList<Player> players, LetterBag bag, Board board){
        this.players = players;
        this.letterBag = bag;


    }

    Player startGame(){
        return currentPlayer =
                players.get(
                        new Random().nextInt(players.size()));
    }

    Player nextPlayer(Player player){

        if (players.iterator().hasNext()){
            return currentPlayer = players.iterator().next();
        } else {
            return currentPlayer = players.get(0);
        }
    }

    HBox topBox(){
        HBox hBox = new HBox();

        hBox.getChildren().add(text);
        return hBox;
    }
}
