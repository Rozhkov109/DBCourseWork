package Entities.Services;

import Entities.Classes.ReviewView;
import Entities.DAO_Interfaces.ReviewViewDAO;

import java.util.List;

public class ReviewViewService {
    private ReviewViewDAO reviewViewDAO;

    public ReviewViewService(ReviewViewDAO reviewViewDAO) {
        this.reviewViewDAO = reviewViewDAO;
    }

    public List<ReviewView> getReviewViewByGuestId(int guestId) {
       return reviewViewDAO.getReviewViewByGuestId(guestId);
    }
}
