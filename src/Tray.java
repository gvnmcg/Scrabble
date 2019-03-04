import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.LinkedList;

public class Tray {

    LinkedList<Letter> letters;

    Letter selected = null;

    TrayDisplay trayDisplay;

    public Tray(LetterBag bag, TrayDisplay trayDisplay) {

        this.trayDisplay = trayDisplay;

        letters= new LinkedList<>();

        for (int i = 0; i < 7; i++) {

            letters.add(bag.draw());
        }


    }

    void selectLetter(Letter letter){
        if (selected != null){
            letters.add(selected);
        } else {
            selected = letter;
            letters.remove(letter);
        }
    }

    EventHandler<MouseEvent> handleLetterSelection(Letter letter){
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                selected = letter;

            }
        };
    }

    @Override
    public String toString() {

        String rep = "";

        for (Letter l : letters){

            rep += l.getChar();
        }

        return rep;
    }
}
