import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

public class TrayDisplay {

    HBox hBox = new HBox();

//    Rectangle divider = new Rectangle(10, 10);
    Group divider = new Group();

    Tray tray;

    Contoller contoller;

    TrayDisplay(Tray tray, Contoller contoller){
        this.tray = tray;
        this.contoller= contoller;
        Group g;
        for (Letter l : tray.letters){

            g = DisplayComponents.makeLetterGroup(l);
            g.addEventHandler(MouseEvent.MOUSE_CLICKED, contoller.handleLetterSelection(l));
            g.addEventHandler(MouseEvent.MOUSE_CLICKED, handleLetterSelection(l, g));

            hBox.getChildren().add(g);
        }

        hBox.getChildren().add(divider);

        //add selected letter space;
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
