/**
 * Load LetterBag, Board, Players, Trays, and
 */
public class Manager {


    private LetterBag bag;

    private Board board;

    private Player currentPlayer;

    private Player p1;

    private ComputerPlayer p2;

    private Controller controller;

    private Display display;


    Manager(){

        //setup Game objects
        bag = new LetterBag();
        board = new Board();
        board.printBoard();

        p1 = new Player(board, bag);

        p2 = new ComputerPlayer(board, bag);

        currentPlayer = p1;
        this.controller = new Controller(this);

    }

    /**
     *
     *  init display components in Game Objects
     *  init display components in display class
     *
     *  set first player diplay //TODO move
     * @param display
     */
    public void setDisplay(Display display) {
        this.display = display;
        display.setController(controller);

        board.setBoardDisplay(display.makeBoardDisplay(board));

        //TODO make multiple players
        p1.setPlayerDisplay(display.makePlayerDisplay(currentPlayer));
        display.setCurrentPlayerDisplay(p1);

    }
}
