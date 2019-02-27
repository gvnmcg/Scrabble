public class Manager {




    LetterBag bag = new LetterBag();

    Board board;

    Dictionary dictionary;

    Player p1;

    Player p2;

    Manager(Display display){


        board = new Board(display);
    }
}
