package JavaFX;

import Entities.Classes.Guest;
import Entities.Classes.Room;
import Entities.Classes.RoomsView;
import Entities.DAO_Implementation.OrderAndReservationDAOImpl;
import Entities.DAO_Implementation.RoomDAOImpl;
import Entities.Services.OrderAndReservationService;
import Entities.Services.RoomService;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AddReservationController {
    RoomsView roomsView;

    public MainWindowController mainWindowController;

    @FXML
    private TextArea reservationInfoTextArea;

    @FXML
    private TextField priceTextField;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private TextField commentTextField;

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

    public void setRoomsView(RoomsView roomsView) {
        this.roomsView = roomsView;
    }

    public void countOrderPrice(ActionEvent actionEvent) {
        if (startDatePicker.getValue() != null && endDatePicker.getValue() != null) {
            int days = (int) ChronoUnit.DAYS.between(startDatePicker.getValue(),endDatePicker.getValue());
            priceTextField.setText(Double.toString(days * roomsView.getPricePerNight()));
        }
    }

    public void addReservation(ActionEvent actionEvent) {
        if (startDatePicker.getValue() != null && endDatePicker.getValue() != null && commentTextField.getText() != null) {
            try {
                Path filePath = Paths.get("src/main/java/Data/XML/GuestData.xml");

                XStream xStream = new XStream();
                xStream.addPermission(AnyTypePermission.ANY);

                xStream.alias("Guest", Guest.class);

                Guest guest = (Guest) xStream.fromXML(new String(Files.readAllBytes(filePath)));

                int guestId = guest.getId();
                int roomId = roomsView.getRoomId();
                LocalDateTime startTime = startDatePicker.getValue().atTime(12, 0);
                LocalDateTime endTime = endDatePicker.getValue().atTime(10, 0);
                String comment = commentTextField.getText();

                OrderAndReservationService orderAndReservationService = new OrderAndReservationService(new OrderAndReservationDAOImpl());
                RoomService roomService = new RoomService(new RoomDAOImpl());
                orderAndReservationService.addOrderWithReservation(guestId,roomId,startTime,endTime,comment);
                roomService.updateRoomStatus(roomId, Room.RoomStatus.OCCUPIED);

                commentTextField.setText("Бронювання додано успішно!");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void showOrderInfo(ActionEvent actionEvent) {
        reservationInfoTextArea.setText(
                "Готель: " + roomsView.getName() + "\nКраїна: " + roomsView.getCountry() + "\nМісто: " + roomsView.getCity() +"\nЦіна за ніч: " + roomsView.getPricePerNight() +
                        "\nТип номеру: " + roomsView.getRoomType().getType()
        );
    }
}
