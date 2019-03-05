import java.util.LinkedList;

public class ComputerPlayer extends Player {

    Board board;
    Dictionary dictionary;

    ComputerPlayer(String name){
        super(name);

    }

    ComputerPlayer(String name, Dictionary dictionary){
        super(name);

        this.dictionary = dictionary;
    }

    void makeMove(){

        LinkedList<BoardSpace> boardSpaces = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            boardSpaces.add(board.getBoardSpace(10, i + 7));
        }

        dictionary.findWordFromTray(getTray(), boardSpaces);

    }


    public void setBoard(Board board) {
        this.board = board;
    }

    public static void main(String[] args) {



        LetterBag bag = new LetterBag();

        Player p = new ComputerPlayer(" cpu", new Dictionary());
        Board b = new Board();

        b.placeLetter(b.getBoardSpace(7,7), new Letter("c 1"));
        b.placeLetter(b.getBoardSpace(8,7), new Letter("a 1"));
        b.placeLetter(b.getBoardSpace(9,7), new Letter("t 1"));
        b.placeLetter(b.getBoardSpace(10,7), new Letter("t 1"));


        System.out.println(b);

        ((ComputerPlayer)p).setBoard(b);

        p.setTrayList(bag);
        ((ComputerPlayer) p).makeMove();

    }
}
