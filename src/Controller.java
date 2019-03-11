import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Handles user input
 */
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
            }
        };
    }

    EventHandler<MouseEvent> handleSpaceClick(BoardSpace bs) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                manager.selectBoardSpace(bs);
            }
        };
    }

    EventHandler<MouseEvent> handleReset() {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                manager.resetMove();
            }
        };
    }


    EventHandler<MouseEvent> handleConfirm() {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                manager.confirmWord();
            }
        };
    }

    EventHandler<MouseEvent> handleExchange() {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                manager.exchange();
            }
        };
    }

}
