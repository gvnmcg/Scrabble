import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BoardDisplay {


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
