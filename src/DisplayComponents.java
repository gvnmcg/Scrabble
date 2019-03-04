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

        Rectangle r = new Rectangle(
                scale + (scale * (.35)),
                scale + (scale * (.35)));
        r.setFill(Color.LIGHTGREY);
        r.setStroke(Color.LIGHTGREY);
        g.getChildren().add(r);

        Text t = null;
        //score

        if (ws.getWordScoreMultiplier() > 1){
            t = new Text(String.valueOf(ws.getWordScoreMultiplier()));
            r.setFill(Color.LIGHTSALMON);

        } else if (ws.getLetterScoreMultiplier() > 1){
            t = new Text(String.valueOf(ws.getLetterScoreMultiplier()));
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

//        r.setTranslateX(scale * (.15));
//        r.setTranslateY(scale * (.15));

        g.setLayoutX(5);
        g.setLayoutY(5);
        g.getChildren().add(r);

        //letter
        Text t;
        t = new Text(String.valueOf(l.getChar()));
        t.setFont(Font.font(25));
        t.setX(scale * (.25));
        t.setY(scale * (.85));
        g.getChildren().add(t);

        //score
        t = new Text(String.valueOf(l.getScore()));
        t.setX(scale * (.65));
        t.setY(scale * (.35));
        g.getChildren().add(t);

        return g;

    }
}
