import java.util.LinkedList;

public class Tray {

    LinkedList<Letter> letters;

    public Tray(LetterBag bag) {

        letters= new LinkedList<>();

        for (int i = 0; i < 7; i++) {

            letters.add(bag.draw());
        }
    }

    @Override
    public String toString() {

        String rep = "";

        for (Letter l : letters){

            rep += l.c;
        }

        return rep;
    }
}
