import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class BoardDisplay {

    int leftM = 10;
    int topM = 10;

    Group group = new Group();

    VBox boardVBox;

    ArrayList<HBox> hBoxes;

    Controller controller;

    BoardDisplay(Board board, Controller controller){

        this.controller = controller;

        initBoardSpaces(board);
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

                g = DisplayComponents.makeBoardSpaceGroup(board.getBoardSpace(i,j));

                rowHBow.getChildren().add(g);

                g.addEventHandler(MouseEvent.MOUSE_CLICKED ,
                        handleBlankSpace(board.getBoardSpace(i, j) , g));

                g.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        controller.handleSpaceClick(board.getBoardSpace(i, j), i, j));
            }
        }
        return boardVBox;
    }

    void update(Board board){

        BoardSpace bs = null;

        for (int i = 0; i < 15; i++) {

            for (int j = 0; j < 15; j++) {

               bs = board.getBoardSpace(i, j);

               if (bs.hasLetter()){

                   Node n = hBoxes.get(j).getChildren().get(i);

                   ((Group)n).getChildren().add(DisplayComponents.makeLetterGroup(bs.letter));

               }
            }
        }
    }

    private EventHandler<MouseEvent> handleBlankSpace(BoardSpace bs, Group g) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {



            }
        };
    }

    public VBox getRoot() {
        return boardVBox;
    }
}
