/**
 * Load LetterBag, Board, Players, Trays, and
 */
public class Manager {


    LetterBag bag;

    Board board;

    Player p1;

    ComputerPlayer p2;

    Manager() {
        bag = new LetterBag();
        board = new Board();

        p1 = new Player(board, bag);

        p2 = new ComputerPlayer(board, bag);
    }

    BoardSpace getSpace(int x, int y){
        return board.getBoardSpace(x, y);
    }

    Board getBoard(){
        return board;
    }


    Manager(Display display) {
        board = new Board(display);

    }
}
