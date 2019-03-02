import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Contoller {

    Manager manager;

    Contoller( Manager manager){
        this.manager = manager;
    }


    EventHandler<MouseEvent> handleLetterSelection(Letter l){

        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                manager.selectLetter(l);

            }
        };
    }

    public EventHandler<MouseEvent> handleRedSquare(Rectangle r) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                r.setFill(Color.BLUE);
                System.out.println("wow");
            }
        };
    }
}
