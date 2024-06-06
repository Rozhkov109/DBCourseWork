package JavaFX;

import Entities.Classes.RoomsView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AddReservationController {
    RoomsView view;

    public MainWindowController mainWindowController;

    @FXML
    private TextArea reservationInfoTextArea;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField commentTextField;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;


    @FXML
    private void initialize() {
        startDatePicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(date.isBefore(LocalDate.now()));
            }
        });

        endDatePicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(date.isBefore(LocalDate.now().plusDays(1)));
            }
        });
    }

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    public void setView(RoomsView view) {
        this.view = view;
    }

    public void countOrderPrice(ActionEvent actionEvent) {
        if (startDatePicker.getValue() != null && endDatePicker.getValue() != null) {
            int days = (int) ChronoUnit.DAYS.between(startDatePicker.getValue(),endDatePicker.getValue());
            priceTextField.setText(Double.toString(days * view.getPricePerNight()));
        }
    }

    public void addReservation(ActionEvent actionEvent) {
    }
}
