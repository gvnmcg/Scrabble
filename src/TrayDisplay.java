import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class TrayDisplay {

    VBox vBox = new VBox();

    Rectangle divider = new Rectangle(10, 10);

    Tray tray;

    TrayDisplay(Tray tray){
        this.tray = tray;
        Group g;
        for (Letter l : tray.letters){

            g = DisplayComponents.makeLetterGroup(l);
            g.addEventHandler(MouseEvent.MOUSE_CLICKED, handleLetterSelection(l));

            vBox.getChildren().add(g);
        }

        vBox.getChildren().add(divider);

        //add selected letter space;
    }

    void setEventHandlers(){
        for (int i = 0; i < vBox.getChildren().size(); i++) {
        }
    }

    private EventHandler<MouseEvent> handleLetterSelection(Letter l, Group g) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tray.selectLetter(l);

                vBox.getChildren().remove(divider);
                vBox.getChildren().add(divider);
                vBox.getChildren().remove(g);
            }
        };
    }

}
