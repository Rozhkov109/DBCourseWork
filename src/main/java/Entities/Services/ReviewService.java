package Entities.Services;

import Entities.Classes.Review;
import Entities.DAO_Interfaces.ReviewDAO;

import java.util.List;

public class ReviewService {
    private ReviewDAO reviewDAO;

    public ReviewService(ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }

    void addReview(Review review) {
        reviewDAO.addReview(review);
    }
    List<Review> getAllReviewsByGuestId(int guestId) {
        return reviewDAO.getAllReviewsByGuestId(guestId);
    }
    void deleteReviewByGuestId(int reviewId) {
        reviewDAO.deleteReviewByGuestId(reviewId);
    }
}
