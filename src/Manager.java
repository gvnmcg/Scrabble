/**
 * Load LetterBag, Board, Players, Trays, and
 */
public class Manager {


    LetterBag bag = new LetterBag();

    Board board;

    Player p1;

    ComputerPlayer p2;



    Manager(Display display){


        board = new Board(display);
    }



}
