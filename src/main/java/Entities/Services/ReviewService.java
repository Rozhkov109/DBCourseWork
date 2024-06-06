package Entities.Services;

import Entities.Classes.Review;
import Entities.DAO_Interfaces.ReviewDAO;

import java.util.List;

public class ReviewService {
    private ReviewDAO reviewDAO;

    public ReviewService(ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }

    public void addReview(Review review) {
        reviewDAO.addReview(review);
    }
    public List<Review> getAllReviewsByGuestId(int guestId) {
        return reviewDAO.getAllReviewsByGuestId(guestId);
    }
    public void deleteReviewByGuestId(int reviewId) {
        reviewDAO.deleteReviewByGuestId(reviewId);
    }
}
