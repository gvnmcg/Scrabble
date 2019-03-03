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

    long time;


    Manager(){

        //setup Game objects
        bag = new LetterBag();
        board = new Board();

        p1 = new Player(board, bag);

        p2 = new ComputerPlayer(board, bag);

        currentPlayer = p1;
        this.controller = new Controller(this);

    }


    public void selectLetter(Letter l) {

        currentPlayer.setSelectedLetter(l);
    }

    public void selectBoardSpace(BoardSpace bs) {

        //move selected Letter to a list , board.currentMove
        // put letter on board
        board.placeLetter(bs, currentPlayer.getSelectedLetter());

        //remove from player disp
        //notify if this is a playable word
        //
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

        //board display
        board.setBoardDisplay(display.makeBoardDisplay(board));

        //player displays
        //TODO make multiple players, for now just show p1

        PlayerDisplay playerDisplay = display.makePlayerDisplay(p1);
        p1.setPlayerDisplay(playerDisplay);
        display.setCurrentPlayerDisplay(p1);


    }



}
