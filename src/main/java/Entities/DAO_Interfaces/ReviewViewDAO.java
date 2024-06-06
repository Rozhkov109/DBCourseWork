package Entities.DAO_Interfaces;

import Entities.Classes.ReviewView;

import java.util.List;

public interface ReviewViewDAO {
    List<ReviewView> getReviewViewByGuestId(int guestId);
}
