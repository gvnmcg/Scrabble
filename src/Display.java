import javafx.scene.Group;
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

    void addLetterToBoard(Letter l, int x, int y){

    }


    void makeBoard(){

        center
    }

    void placeLetter(Letter l, int n){

        Group g = components.makeLetterGroup(l);

        g.setLayoutX(((n % 15) + (int)(n/15)) * scale);
        g.setLayoutY( n * scale );

        center.getChildren().add(g);

    }

    public BoardDisplay makeBoardDisplay() {

        BoardDisplay boardDisplay = new BoardDisplay();
        return  boardDisplay;
    }
}
