import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.util.LinkedList;

public class PlayerDisplay {

    HBox hBox;

    Group divider = new Group();

    Controller controller;

    PlayerDisplay(Player player, Controller controller){
        this.controller = controller;

        hBox = new HBox();
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.getChildren().add(divider);

        //init
        update(player.getTrayList());
    }

    void update(LinkedList<Letter> letters){

        Group g;

        hBox.getChildren().clear();
        for (Letter l : letters){
            g = DisplayComponents.makeLetterGroup(l);
            hBox.getChildren().add(g);
            addHandlers(g, l);
        }

    }

    private void addHandlers(Group g, Letter l){
        g.addEventHandler(MouseEvent.MOUSE_CLICKED, controller.handleLetterSelection(l));
    }


    public HBox getRoot() {
        return hBox;
    }
}
