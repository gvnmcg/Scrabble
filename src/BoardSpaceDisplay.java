import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardSpaceDisplay {

    Rectangle rep;

    int spaceSize = 30;

    BoardSpaceDisplay(BoardSpace bs, int x, int y){

        rep = new Rectangle( x, y, spaceSize, spaceSize);
        if (bs.wsm > 1){
            rep.setFill(Color.RED);
        } else if (bs.lsm > 1){
            rep.setFill(Color.BLUE);
        } else {
            rep.setFill(Color.TAN);
        }
    }
}
