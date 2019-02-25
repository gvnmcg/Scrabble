import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Display display = new Display();


        display.placeLetter(new Letter('c', 3), 4);
        display.placeLetter(new Letter('d', 3), 5);


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(display.layout, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
