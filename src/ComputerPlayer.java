public class ComputerPlayer extends Player {

    Board board;

    ComputerPlayer(String name){
        super(name);

    }



    public void setBoard(Board board) {
        this.board = board;
    }
}
