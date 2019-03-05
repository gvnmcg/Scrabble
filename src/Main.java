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
        Manager manager = new Manager();

        StartGame startGame = new StartGame(
                scrabble, manager, primaryStage, display);

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
