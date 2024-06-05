package Entities.DAO_Implementation;

import Entities.Classes.Guest;
import Entities.Classes.Review;
import Entities.DAO_Interfaces.ReviewDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImpl implements ReviewDAO {

    private Connection connection;

    private final String ADD_REVIEW = "{call review_add(?, ?, ?, ?)}";
    private static final String SELECT_ALL_REVIEWS = "SELECT * FROM hotelreservations.review";
    private final String DELETE_REVIEW = "DELETE FROM hotelreservations.review WHERE Review_id = ?";


    public ReviewDAOImpl() {
        try {
            String URL = "jdbc:mysql://localhost:3306/hotelreservations";
            String USER = "root";
            String PASSWORD = "";
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addReview(Review review) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_REVIEW);
            preparedStatement.setInt(1, review.getGuestID());
            preparedStatement.setInt(2, review.getHotelID());
            preparedStatement.setInt(3, review.getRating());
            preparedStatement.setString(4, review.getComment());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Review> getAllReviewsByGuestId(int guestId) {
        try {
            List<Review> reviewList = new ArrayList<>();

            Statement statement = connection.createStatement();
            ResultSet setOfReviews = statement.executeQuery(SELECT_ALL_REVIEWS);

            while (setOfReviews.next()) {
                reviewList.add(new Review(
                        setOfReviews.getInt("Review_id"),
                        setOfReviews.getInt("Guest_id"),
                        setOfReviews.getInt("Hotel_id"),
                        setOfReviews.getTimestamp("Date").toLocalDateTime(),
                        setOfReviews.getInt("Rating"),
                        setOfReviews.getString("Comment")));
            }
            return reviewList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteReviewByGuestId(int reviewId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_REVIEW);
            preparedStatement.setInt(1, reviewId);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
