import java.util.LinkedList;

public class ComputerPlayer extends Player {

    private Board board;
    private Dictionary dictionary;

    ComputerPlayer(String name){
        super(name);

    }

    ComputerPlayer(String name, Dictionary dictionary){
        super(name);

        this.dictionary = dictionary;
    }

    public void setBoard(Board board) {
        this.board = board;
    }


}
