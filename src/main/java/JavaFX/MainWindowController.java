package JavaFX;

import Entities.Classes.RoomsView;
import Entities.DAO_Implementation.OrderAndReservationDAOImpl;
import Entities.DAO_Implementation.RoomDAOImpl;
import Entities.DAO_Implementation.RoomsViewDAOImpl;
import Entities.Services.OrderAndReservationService;
import Entities.Services.RoomService;
import Entities.Services.RoomsViewService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;

public class MainWindowController {

    ObservableList<RoomsView> roomsList;

    @FXML
    private Button profileButton;

    @FXML
    private Button addOrderWithReservationButton;

    @FXML
    private TableView<RoomsView> roomsViewTable;

    @FXML
    private TableColumn<RoomsView, String> hotelColumn;

    @FXML
    private TableColumn<RoomsView, String> countryColumn;

    @FXML
    private TableColumn<RoomsView, String> cityColumn;

    @FXML
    private TableColumn<RoomsView, Double> priceColumn;

    @FXML
    private TableColumn<RoomsView, String> typeColumn;

    @FXML
    private TableColumn<RoomsView, String> statusColumn;

    @FXML
    private TableColumn<RoomsView, Integer> capacityColumn;

    @FXML
    private TableColumn<RoomsView, LocalDateTime> endDateColumn;

    @FXML
    private void initialize() {
        updateDataInRoomsView();
        updateTable();
    }

    private void updateDataInRoomsView() {
        OrderAndReservationService orderAndReservationService = new OrderAndReservationService(new OrderAndReservationDAOImpl());
        orderAndReservationService.updateReservationsAndRoomsData();
        RoomsViewService roomsViewService = new RoomsViewService(new RoomsViewDAOImpl());
        roomsViewService.updateRoomsView();
    }

    private void updateTable() {
        RoomsViewService roomsViewService = new RoomsViewService(new RoomsViewDAOImpl());
        roomsList = FXCollections.observableArrayList(roomsViewService.getRoomsView());

        hotelColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("pricePerNight"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        roomsViewTable.setItems(roomsList);
    }

    public void goToProfileWindow(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public void createReservation(ActionEvent actionEvent) {
    }
}
