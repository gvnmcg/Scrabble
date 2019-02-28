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

        System.out.println("p1 tray: " + p1.tray.toString());

        p2 = new ComputerPlayer(board, bag);

        System.out.println("p1 tray: " + p2.tray.toString());

    }

    BoardSpace getSpace(int x, int y){
        return board.getBoardSpace(x, y);
    }

    Board getBoard(){
        return board;
    }

    public static void main(String[] args) {
        Manager manager = new Manager();

    }
}
