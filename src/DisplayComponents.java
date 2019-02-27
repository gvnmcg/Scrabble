import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class DisplayComponents {

    int scale;

    DisplayComponents(int scale){
        this.scale = scale;
    }


    Group makeWordSpaceGroup(BoardSpace ws){

        Group g = new Group();

        Rectangle r = new Rectangle(scale, scale);
        r.setFill(Color.LIGHTGREEN);
        r.setStroke(Color.LIGHTGREY);
        g.getChildren().add(r);

        Text t = null;
        //score

        if (ws.wsm > 1){
            t = new Text(String.valueOf(ws.wsm));

        } else if (ws.lsm > 1){
            t = new Text(String.valueOf(ws.lsm));

        }
        t.setX(35);
        t.setY(15);
        g.getChildren().add(t);


        return g;
    }

    Group makeLetterGroup(Letter l){

        Group g = new Group();

        Rectangle r = new Rectangle(scale, scale);
        r.setFill(Color.GREEN);
        r.setStroke(Color.BROWN);
        g.getChildren().add(r);

        //letter
        Text t;
        t = new Text(String.valueOf(l.c));
        t.setFont(Font.font(25));
        t.setX(scale * (double)(1/2));
        t.setY(scale * (double)(5/4));
        g.getChildren().add(t);

        //score
        t = new Text(String.valueOf(l.score));
        t.setX(35);
        t.setY(15);
        g.getChildren().add(t);

        return g;

    }
}