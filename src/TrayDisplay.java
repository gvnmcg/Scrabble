import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class TrayDisplay {

    HBox hBox ;

//    Rectangle divider = new Rectangle(10, 10);
    Group divider = new Group();

    Controller controller;

    TrayDisplay(Player player, Controller controller){
        this.controller = controller;

        hBox = new HBox();
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.getChildren().add(divider);

    }

    void addHandlers(Tray tray){
        Group g;
        for (Letter l : tray.letters){

            g = DisplayComponents.makeLetterGroup(l);
            g.addEventHandler(MouseEvent.MOUSE_CLICKED, controller.handleLetterSelection(l));
            g.addEventHandler(MouseEvent.MOUSE_CLICKED, handleLetterSelection(l, g));

            hBox.getChildren().add(g);
        }
    }


    private EventHandler<MouseEvent> handleLetterSelection(Letter l, Group g) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hBox.getChildren().remove(divider);
                hBox.getChildren().add(divider);
                hBox.getChildren().remove(g);
                hBox.getChildren().add(g);

            }
        };
    }

}
