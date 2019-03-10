import java.util.LinkedList;

/**
 * Load LetterBag, Board, Players, Trays, and
 */
public class Manager {


    private LetterBag bag;

    private Board board;

    private Player currentPlayer;

    private Controller controller;

    private Display display;
    
    private Scrabble scrabble;

    private Dictionary dictionary;

    private boolean firstMove;


    Manager() {


        //setup Game objects
        bag = new LetterBag();
        board = new Board();

        this.controller = new Controller(this);

        dictionary = new Dictionary();
    }

    void startGame(Scrabble scrabble) {
        this.scrabble = scrabble;

        for (Player p : scrabble.getPlayers()) {
            p.setTrayList(bag);

            if (p instanceof ComputerPlayer) {
                ((ComputerPlayer) p).setBoard(board);
            }
        }
        currentPlayer = scrabble.getPlayers().peek();

        firstMove = true;

    }


    /**
     * Event Handler method:
     * <p>
     * -assign players selected letter
     * -move sL to end
     * -move Sl Group to End
     *
     * @param l
     */
    public void selectLetter(Letter l) {

        currentPlayer.setSelectedLetter(l);
    }

    /**
     * Event Handler:
     * <p>
     * -remove selected letter from player tray
     * -addLetterGroup player display
     * <p>
     * -place letter in board data structure
     * -place letter group in boardSpace Group
     *
     * @param bs
     */
    public void selectBoardSpace(BoardSpace bs) {

        //if its the first move, it must be placed in the center
        if (firstMove) {
            if (!board.getBoardSpace(
                    board.sideLength / 2,
                    board.sideLength / 2).equals(bs)) {
                scrabble.text.setText("please place in center space");
                return;
            } else {
                firstMove = false;
            }
        }
        //just place the letter
        currentPlayer.placeLetter(bs, board);

    }

    public void resetMove() {

        currentPlayer.resetMove();
        board.resetMove();
    }

    boolean confirmWord() {
        //dictionary confirms word -if
        // confirm board

        if (currentPlayer.getCurrentMove().isEmpty()) {
            scrabble.setText("Please place letters " + currentPlayer.getName());
            return false;
        }

        if (board.confirmBoard(dictionary)) {

            //add score
            int points = board.computeMove();
            scrabble.setText(currentPlayer.getName() + " made "
                    + points + "points");
            currentPlayer.addPoints(points);

            //reset moves
            currentPlayer.confirmWord();

            //refill bag
            currentPlayer.refillTray(bag);
            if (bag.isEmpty()){
                scrabble.setText("Game Over " + currentPlayer.getName() + " Wins!");
            } else {
                //switch player
                currentPlayer = scrabble.nextPlayer(currentPlayer);
                display.setCurrentPlayerDisplay(currentPlayer);

//            if (currentPlayer instanceof ComputerPlayer){
//                ((ComputerPlayer) currentPlayer).makeMove();
//            }
                return true;
            }


        }
        resetMove();
        return false;
    }

    void exchange(){

        currentPlayer.exchange(bag);
    }

    /**
     * init display components in Game Objects
     * init display components in display class
     * <p>
     * set first player diplay //TODO move
     *
     * @param display
     */
    public void setDisplay(Display display) {
        this.display = display;

        //so the display can be interactive
        display.setController(controller);

        //board display
        board.setBoardDisplay(display.makeBoardDisplay(board));

        //player displays
        for (Player p : scrabble.getPlayers()) {
            p.setPlayerDisplay(display.makePlayerDisplay(p));
        }

        display.setCurrentPlayerDisplay(currentPlayer);

        display.setGameInfo(scrabble);

    }


}
