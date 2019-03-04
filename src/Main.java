import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Load Scrabble, Game Data, Display Components, and Launch Window
 */
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Scrabble");

        Scrabble scrabble = new Scrabble();
        Display display = new Display();

        StartGame startGame = new StartGame(scrabble, primaryStage, display.getScene());

        Manager manager = new Manager(scrabble);
        manager.setDisplay(display);

//        primaryStage.setScene(new Scene(display.getLayout(),
//                Display.WIDTH, Display.HEIGHT));
        primaryStage.show();

        manager.startGame();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
