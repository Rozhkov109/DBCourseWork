import Entities.Classes.Guest;
import Entities.DAO_Implementation.GuestDAOImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.sql.Date;

public class Main extends Application {

    public static void main(String[] args) {
        GuestDAOImpl guest = new GuestDAOImpl();

        System.out.println(guest.getGuestById(10));
        System.out.println(guest.getGuestByEmail("viktoriia.pavliuchenko945@gmail.com"));
        System.out.println(guest.getAllGuests());
//        launch(args);
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