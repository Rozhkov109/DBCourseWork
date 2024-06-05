import Entities.Classes.Guest;
import Entities.DAO_Implementation.GuestDAOImpl;
import Entities.DAO_Implementation.OrderAndReservationDAOImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.sql.Date;

public class Main extends Application {

    public static void main(String[] args) {

    // launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("Система бронювання готелів");

        stage.setOnCloseRequest(event -> onCloseAction());

        stage.setScene(scene);
        stage.show();
    }

    private void onCloseAction() {
    }
}