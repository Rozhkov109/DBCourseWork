package Entities.DAO_Implementation;

import Entities.Classes.ReviewView;
import Entities.DAO_Interfaces.ReviewViewDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewViewDAOImpl implements ReviewViewDAO {

    private Connection connection;

    private static final String SELECT_ALL_FROM_REVIEW_VIEW_BY_GUEST_ID = "SELECT * FROM hotelreservations.guest_reviews WHERE Guest_id = ?";

    public ReviewViewDAOImpl() {
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
    public List<ReviewView> getReviewViewByGuestId(int guestId) {
        try {
            List<ReviewView> reviewViewList = new ArrayList<>();

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_REVIEW_VIEW_BY_GUEST_ID);
            preparedStatement.setInt(1, guestId);

            ResultSet setOfReviewView = preparedStatement.executeQuery();

            while (setOfReviewView.next()) {
                reviewViewList.add(new ReviewView(
                        setOfReviewView.getInt("Guest_id"),
                        setOfReviewView.getTimestamp("Date").toLocalDateTime(),
                        setOfReviewView.getString("HotelName"),
                        setOfReviewView.getInt("Rating"),
                        setOfReviewView.getString("Comment")));
            }
            return reviewViewList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
