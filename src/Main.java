import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Load Scrabble, Game Data, Display Components, and Launch Window
 */
public class Main extends Application {

    Stage winow;

    @Override
    public void start(Stage primaryStage) throws Exception{

        winow = primaryStage;

//        Manager manager = new Manager();
//        Controller controller = new Controller(manager);
//        Display display = new Display(manager, controller);

        Display display = new Display();
        Manager manager = new Manager();
        manager.setDisplay(display);

        primaryStage.setTitle("Scrabble");
        primaryStage.setScene(new Scene(display.getLayout(), Display.WIDTH, Display.HEIGHT));
        primaryStage.show();

        manager.startGame();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
