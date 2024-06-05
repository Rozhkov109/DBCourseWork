package JavaFX;

import Entities.Classes.RoomsView;
import Entities.DAO_Implementation.RoomsViewDAOImpl;
import Entities.Services.RoomsViewService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
        updateTable();
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

    public void createReservation(ActionEvent actionEvent) {
    }
}
