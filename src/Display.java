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
    final static int HEIGHT = 1000;

    int LEFT_MARGIN = 10;
    int TOP_MARGIN = 20;

    BorderPane layout = new BorderPane();

    Group center;



    int scale = 30;

    HashMap<Integer, Group> letterGroupMap = new HashMap<>();

    Display(){

        components = new DisplayComponents(scale);

        center = new Group();
        layout.setCenter(center);

    }

    Display(Manager manager, Contoller contoller){
        this();


        BoardDisplay boardDisplay = new BoardDisplay(manager.getBoard(), contoller);

        TrayDisplay p1TrayDisplay = new TrayDisplay(manager.p1.tray, contoller);
        TrayDisplay p2TrayDisplay = new TrayDisplay(manager.p2.tray, contoller);



        center.getChildren().add(boardDisplay.boardVBox);

        layout.setBottom(p1TrayDisplay.hBox);
    }



}
