import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BoardDisplay {

    //root of the display
    private VBox boardVBox;

    //access the hboes in the vbox
    private ArrayList<HBox> hBoxes = new ArrayList<>();

    //determines actions when groups are clicked
    private Controller controller;

    //space to group
    private HashMap<BoardSpace, Group> groupMap = new HashMap<>();

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
        BoardSpace bs;

        //add row (hbox) to Vbox
        for (int i = 0; i < 15; i++) {

            boardVBox.getChildren().add(rowHBow = new HBox());
            rowHBow.setAlignment(Pos.TOP_CENTER);
            hBoxes.add(rowHBow);

            //creates and adds groups to Hboxes
            //adds controllers event handlers
            for (int j = 0; j < 15; j++) {

                //map game object to display object
                bs = board.getBoardSpace(i,j);
                g = DisplayComponents.makeBoardSpaceGroup(bs);

                groupMap.put(bs, g);

                //add
                rowHBow.getChildren().add(g);

                g.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        controller.handleSpaceClick(board.getBoardSpace(i, j)));
            }
        }
    }

    /**
     * add a letter group to board space Group
     * @param bs
     * @param l
     */
    void addLetterGroup(BoardSpace bs, Letter l) {

        Group bsGroup = groupMap.get(bs);
        Group letterGroup = DisplayComponents.makeLetterGroup(l);

        bsGroup.getChildren().add(letterGroup);

    }

    /**
     * remove a letter space form a board group
     * undoes addLetterGroup
     * @param move
     */
    void removeMove(LinkedList<BoardSpace> move) {
        Group g;
        
        for (BoardSpace bs : move){
            
            g = groupMap.get(bs);
            g.getChildren().remove(g.getChildren().size() - 1);
        }

    }



    public VBox getRoot() {
        return boardVBox;
    }


    public void update(HashMap<BoardSpace,Letter> letterMap) {
    }
}
