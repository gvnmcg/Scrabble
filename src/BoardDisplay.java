import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.Controller;

import java.util.ArrayList;

public class BoardDisplay {

    int leftM = 10;
    int topM = 10;

    Group group = new Group();

    VBox boardVBox;

    ArrayList<HBox> hBoxes;

    BoardDisplay(Board board, Contoller contoller){

        initBoardSpaces(board);
    }

    void addHandlers(BoardSpace bs, Controller controller){

        for (HBox hBox : hBoxes){


        }
    }


    VBox initBoardSpaces(Board board){

        boardVBox = new VBox();
        HBox rowHBow;
        hBoxes = new ArrayList<>();

        Group g;

        for (int i = 0; i < 15; i++) {

            boardVBox.getChildren().add(rowHBow = new HBox());
            hBoxes.add(rowHBow);

            for (int j = 0; j < 15; j++) {

                rowHBow.getChildren().add(
                        g = DisplayComponents.makeBoardSpaceGroup(
                                board.getBoardSpace(i,j)));
            }
        }
        return boardVBox;
    }
}
