package JavaFX;

import Entities.Classes.Guest;
import Entities.DAO_Implementation.GuestDAOImpl;
import Entities.Services.GuestService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class AuthorizationController {

    @FXML
    private DatePicker birthDateField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passportField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField emailLoginField;

    @FXML
    private TextField passwordLoginField;

    @FXML
    void goToLoginPage(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goToRegistrationPage(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goToMainPage(Guest guest,ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void registerGuest(ActionEvent event) throws IOException {
        String name = nameField.getText();
        String surname = surnameField.getText();
        LocalDate birthDate = birthDateField.getValue();
        String phoneNumber = phoneField.getText();
        String email = emailField.getText();
        String passportNumber = passportField.getText();
        String password = passwordField.getText();

        if (name != null && surname != null && birthDate != null &&
                phoneNumber != null && email!=null && passportNumber != null && password != null) {
            GuestService guestService = new GuestService(new GuestDAOImpl());
            guestService.register(new Guest(name,surname,birthDate,phoneNumber,email,passportNumber,password));
            goToLoginPage(event);
        }
    }



    @FXML
    void loginGuest(ActionEvent event) throws IOException {
        String email = emailLoginField.getText();
        String password = passwordLoginField.getText();
        if (email != null && password != null) {
            GuestService guestService = new GuestService(new GuestDAOImpl());
            // Перехід на основну сторінку
            goToMainPage(guestService.login(email,password),event);
        }
    }
}
