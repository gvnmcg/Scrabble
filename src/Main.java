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


//        Display display = new Display();
//        Manager manager = new Manager(display);

        Manager manager = new Manager();
        Display display = new Display(manager);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(display.layout, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
