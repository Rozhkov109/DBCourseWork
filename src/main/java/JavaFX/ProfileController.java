package JavaFX;

import Entities.Classes.Guest;
import Entities.Classes.ReviewView;
import Entities.DAO_Implementation.ReviewViewDAOImpl;
import Entities.Services.ReviewViewService;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class ProfileController {

    private Guest guest;

    private ObservableList<ReviewView> reviewList;

    @FXML
    private TextArea personalDataTextArea;

    @FXML
    private TableView<ReviewView> reviewTable;

    @FXML
    private TableColumn<ReviewView, LocalDateTime> dateColumn;

    @FXML
    private TableColumn<ReviewView, String> hotelColumn;

    @FXML
    private TableColumn<ReviewView, Integer> ratingColumn;

    @FXML
    private TableColumn<ReviewView, String> reviewTextColumn;


    public Guest getGuest() {
        return guest;
    }

    @FXML
    private void initialize() {
        setUserData();
        setReviews();
        setReservations();
    }

    public void setUserData() {
        try{
            Path filePath = Paths.get("src/main/java/Data/XML/GuestData.xml");

            XStream xStream = new XStream();
            xStream.addPermission(AnyTypePermission.ANY);

            xStream.alias("Guest", Guest.class);

            guest = (Guest) xStream.fromXML(new String(Files.readAllBytes(filePath)));

            personalDataTextArea.setText("Ім'я: " + guest.getFirstName() + "\nПрізвище: " + guest.getSecondName() + "\nДата народження: " +
                    guest.getPhoneNumber() + "\nЕлектронна пошта: " + guest.getEmail());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setReviews() {
        ReviewViewService reviewViewService = new ReviewViewService(new ReviewViewDAOImpl());
        reviewList = FXCollections.observableList(reviewViewService.getReviewViewByGuestId(guest.getId()));

        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        hotelColumn.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        reviewTextColumn.setCellValueFactory(new PropertyValueFactory<>("comment"));

        reviewTable.setItems(reviewList);
    }

    public void setReservations() {

    }

    public void goToMainWindow(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public void addReview(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddReview.fxml"));
        Parent root = loader.load();

        AddReviewController addReviewController = loader.getController();
        addReviewController.setProfileWindowController(this);

        Stage stage = new Stage();
        stage.setTitle("Додати запис");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
