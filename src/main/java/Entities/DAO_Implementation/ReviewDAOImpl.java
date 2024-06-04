package Entities.DAO_Implementation;

import Entities.Classes.Review;
import Entities.DAO_Interfaces.ReviewDAO;

import java.sql.Connection;
import java.util.List;

public class ReviewDAOImpl implements ReviewDAO {

    private Connection connection;

    @Override
    public void addReview(Review review) {

    }

    @Override
    public List<Review> getAllReviewsByGuestId(int guestId) {
        return null;
    }

    @Override
    public void deleteReviewByGuestId(int guestId) {

    }
}
