import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

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
}
