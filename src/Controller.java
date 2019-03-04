import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Controller {

    private Manager manager;

    Controller(Manager manager){
        this.manager = manager;
    }


    EventHandler<MouseEvent> handleLetterSelection(Letter l){

        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                manager.selectLetter(l);

                System.out.println(l);
            }
        };
    }

    EventHandler<MouseEvent> handleSpaceClick(BoardSpace bs) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO
                System.out.println("handle ");

                manager.selectBoardSpace(bs);
            }
        };
    }
}
