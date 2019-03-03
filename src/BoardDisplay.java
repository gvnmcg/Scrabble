import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class BoardDisplay {

    //root of the display
    VBox boardVBox = new VBox();

    //access the hboes in the vbox
    ArrayList<HBox> hBoxes = new ArrayList<>();

    //determines actions when groups are clicked
    Controller controller;

    BoardDisplay(Board board, Controller controller){
        this.controller = controller;

        boardVBox = new VBox();
        boardVBox.setAlignment(Pos.TOP_CENTER);

        initBoardSpaces(board);
    }


    /**
     * creates the components in the main dats structres
     * @param board
     * @return
     */
    private void initBoardSpaces(Board board){

        HBox rowHBow;
        Group g;

        //add row (hbox) to Vbox
        for (int i = 0; i < 15; i++) {

            boardVBox.getChildren().add(rowHBow = new HBox());
            rowHBow.setAlignment(Pos.TOP_CENTER);
            hBoxes.add(rowHBow);

            //creates and adds groups to Hboxes
            //adds controllers event handlers
            for (int j = 0; j < 15; j++) {

                g = DisplayComponents.makeBoardSpaceGroup(board.getBoardSpace(i,j));

                rowHBow.getChildren().add(g);

                g.addEventHandler(MouseEvent.MOUSE_CLICKED ,
                        handleBlankSpace(board.getBoardSpace(i, j) , g));

                g.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        controller.handleSpaceClick(board.getBoardSpace(i, j), i, j));
            }
        }
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
