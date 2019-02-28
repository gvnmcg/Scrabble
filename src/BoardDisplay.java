import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BoardDisplay {

    int leftM = 10;
    int topM = 10;

    Group group = new Group();

    BoardDisplay(Board board){

        displayEachSpace(board);
    }

    void displayEachSpace(Board board){

        for (int i = 0; i < board.sideLength; i++) {
            for (int j = 0; j < board.sideLength; j++) {
                displaySpace(board.spaces[i][j], i ,j);
            }
        }
    }

    void displaySpace(BoardSpace bs, int x, int y){

        BoardSpaceDisplay bsd = new BoardSpaceDisplay(bs, x, y);
        group.getChildren().add(bsd.rep);
    }


    VBox initBoardSpaces(Board board, DisplayComponents components){

        VBox boardVBox = new VBox();
        HBox rowHBow;

        for (int i = 0; i < 15; i++) {

            boardVBox.getChildren().add(rowHBow = new HBox());

            for (int j = 0; j < 15; j++) {

                rowHBow.getChildren().add(
                        components.makeWordSpaceGroup(
                                board.getBoardSpace(i,j)));
            }
        }
        return boardVBox;
    }
}
