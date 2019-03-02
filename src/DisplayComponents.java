import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class DisplayComponents {

    static double scale;

    DisplayComponents(double scale){
        this.scale = scale;
    }


    static Group makeBoardSpaceGroup(BoardSpace ws){

        Group g = new Group();

        Rectangle r = new Rectangle(scale, scale);
        r.setFill(Color.LIGHTGREY);
        r.setStroke(Color.LIGHTGREY);
        g.getChildren().add(r);

        Text t = null;
        //score

        if (ws.wsm > 1){
            t = new Text(String.valueOf(ws.wsm));
            r.setFill(Color.LIGHTSALMON);

        } else if (ws.lsm > 1){
            t = new Text(String.valueOf(ws.lsm));
            r.setFill(Color.LIGHTBLUE);

        } else {
            t = new Text(".");
        }
        t.setX(scale * (.25));
        t.setY(scale * (.85));
        g.getChildren().add(t);


        return g;
    }

    static Group makeLetterGroup(Letter l){

        Group g = new Group();

        Rectangle r = new Rectangle(scale, scale);
        r.setFill(Color.GREEN);
        r.setStroke(Color.BROWN);
        g.getChildren().add(r);

        //letter
        Text t;
        t = new Text(String.valueOf(l.c));
        t.setFont(Font.font(25));
        t.setX(scale * (.25));
        t.setY(scale * (.85));
        g.getChildren().add(t);

        //score
        t = new Text(String.valueOf(l.score));
        t.setX(scale * (.75));
        t.setY(scale * (.35));
        g.getChildren().add(t);

        return g;

    }
}
