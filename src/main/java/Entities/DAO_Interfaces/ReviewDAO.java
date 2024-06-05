package Entities.DAO_Interfaces;

import Entities.Classes.Review;

import java.util.List;

public interface ReviewDAO {
    void addReview(Review review);
    List<Review> getAllReviewsByGuestId(int guestId);
    void deleteReviewByGuestId(int reviewId);
}
