import java.util.LinkedList;

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

    private Scrabble scrabble;

    private Dictionary dictionary ;

    private boolean firstMove;



    Manager(){

        //setup Game objects
        bag = new LetterBag();
        board = new Board(bag.draw());

        p1 = new Player(board, bag);

        p2 = new ComputerPlayer(board, bag);

        currentPlayer = p1;
        this.controller = new Controller(this);

        dictionary = new Dictionary();
        startGame();

    }

    void startGame(){
        //game
        LinkedList<Player> players = new LinkedList<>();
        players.add(p1);
        players.add(p2);
        scrabble = new Scrabble(players, bag, board);

        firstMove = true;


    }


    /**
     *  Event Handler method:
     *
     *  -assign players selected letter
     *  -move sL to end
     *  -move Sl Group to End
     * @param l
     */
    public void selectLetter(Letter l) {

        currentPlayer.setSelectedLetter(l);
    }

    /**
     *
     * Event Handler:
     *
     * -remove selected letter from player tray
     * -addLetterGroup player display
     *
     * -place letter in board data structure
     * -place letter group in boardSpace Group
     * @param bs
     */
    public void selectBoardSpace(BoardSpace bs) {

        //if its the first move, it must be placed in the center
        if (firstMove){
            if (!board.getBoardSpace(
                    board.sideLength/2,
                    board.sideLength/2).equals(bs)){
                scrabble.text.setText("please place in center space");
                return;
            } else {
                firstMove = false;
            }
        }

        //if the piece was not confirmed, it can be replaced
        if (bs.hasLetter() && currentPlayer.
                getCurrentMove().contains(bs.getLetter())){
            currentPlayer.getTray().add(bs.getLetter());

            //if the piece was already played it cannot be replaces
        } else {

            // move selected Letter to a list , player.currentMove
            // put letter on board
            Letter sL = currentPlayer.removeSelectedLetter();
            board.placeLetter(bs, sL);

            board.confirmBoard(dictionary);
        }


    }

    public void resetMove(){

        //TODO
        currentPlayer.resetMove();
        board.resetMove();
    }

    boolean confirmWord(){
        //TODO
        //dictionary confirms word -if
        // confirm board
        if (board.confirmBoard(dictionary)){


            int points = board.computeMove();
            currentPlayer.addPoints(points);
            System.out.println(" that was " + points + " pts");

            currentPlayer.confirmWord();

            //refill bag
            //reset moves
            currentPlayer.refillTray(bag);


            //switch player
            currentPlayer = scrabble.nextPlayer(currentPlayer);
            display.setGameInfo(scrabble);
        }
        return true;
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

        display.setGameInfo(scrabble);


    }



}
