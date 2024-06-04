package Entities.DAO_Interfaces;

import Entities.Classes.Review;

public interface ReviewDAO {
    void addReview(Review review);
    void getReviewsByGuestId(int guestId);
    void deleteReviewByGuestId(int guestId);
}
