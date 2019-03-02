import java.io.FileNotFoundException;

/**
 * Load LetterBag, Board, Players, Trays, and
 */
public class Manager {


    LetterBag bag;

    Board board;

    public Player currentPlayer;

    Player p1;

    ComputerPlayer p2;

    Manager() {
        bag = new LetterBag();
        board = new Board();
        board.printBoard();

        p1 = new Player(board, bag);

        p2 = new ComputerPlayer(board, bag);

    }

    BoardSpace getSpace(int x, int y){
        return board.getBoardSpace(x, y);
    }

    Board getBoard(){
        return board;
    }



    public static void main(String[] args) throws FileNotFoundException{
        Manager manager = new Manager();

    }


    public void selectLetter(Letter l) {

        currentPlayer.tray.selectLetter(l);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void placeLetter(Letter l, int r, int c) {

        board.placeLetter(l,r,c);
    }
}
