import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("JavaFX/Login.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("Система бронювання готелів");

        stage.setScene(scene);
        stage.show();
    }
}