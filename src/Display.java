import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.HashMap;

public class Display {

    DisplayComponents components;

    final static int WIDTH = 1500;
    final static int HEIGHT = 700;

    int LEFT_MARGIN = 10;
    int TOP_MARGIN = 20;

    BorderPane layout = new BorderPane();

    Group center;

    VBox boardVBox;

    int scale = 50;

    HashMap<Integer, Group> letterGroupMap = new HashMap<>();

    Display(){

        components = new DisplayComponents(scale);

        center = new Group();
        layout.setCenter(center);


    }

    Display(Manager manager, Contoller contoller){
        this();


        BoardDisplay boardDisplay = new BoardDisplay(manager.getBoard());

        TrayDisplay p1TrayDisplay = new TrayDisplay(manager.p1.tray, contoller);
        TrayDisplay p2TrayDisplay = new TrayDisplay(manager.p2.tray, contoller);


//        Rectangle r = new Rectangle(10, 10, 20 , 20);
//        r.setFill(Color.RED);
//        r.addEventHandler(MouseEvent.MOUSE_CLICKED, contoller.handleRedSquare(r));

        center.getChildren().add(p1TrayDisplay.hBox);
    }

    void addLetterToBoard(Letter l, int x, int y){

    }

    void makeBoard(){

    }

    void placeLetter(Letter l, int n){

        Group g = components.makeLetterGroup(l);

        g.setLayoutX(((n % 15) + (int)(n/15)) * scale);
        g.setLayoutY( n * scale );

        center.getChildren().add(g);

    }

    public BoardDisplay makeBoardDisplay() {

        BoardDisplay boardDisplay = new BoardDisplay(null);
        return  boardDisplay;
    }
}
