import java.util.LinkedList;

public class Player {


    Tray tray;

    Player(Board board, LetterBag bag){

        tray = new Tray(bag);
    }


    boolean placeLetter(Letter l, int x, int y){

        return true;
    }

    boolean placeWord(LinkedList<Letter> word, int x, int y){

        return true;
    }
}
