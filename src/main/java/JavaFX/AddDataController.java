package JavaFX;


import Entities.Classes.Review;
import Entities.DAO_Implementation.HotelDAOImpl;
import Entities.DAO_Implementation.ReviewDAOImpl;
import Entities.Services.HotelService;
import Entities.Services.ReviewService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddDataController {

    @FXML
    private TextField hotelNameField;

    @FXML
    private TextField ratingField;

    @FXML
    private TextArea reviewTextArea;

    public ProfileController profileController;

    public void setMainWindowController(ProfileController profileController) {
        this.profileController = profileController;
    }

    public void addReview(ActionEvent actionEvent) {
        String hotelName = hotelNameField.getText();
        int rating = Integer.parseInt(ratingField.getText());
        String reviewText = reviewTextArea.getText();

        HotelService hotelService = new HotelService(new HotelDAOImpl());
        ReviewService reviewService = new ReviewService(new ReviewDAOImpl());
        reviewService.addReview(new Review(
                profileController.getGuest().getId(),
                hotelService.getHotelIdByName(hotelName),
                rating,
                reviewText));
        reviewTextArea.setText("Відгук доданий!!!");
        profileController.setReviews();
    }
}
