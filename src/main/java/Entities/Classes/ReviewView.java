package Entities.Classes;

import java.time.LocalDateTime;

public class ReviewView {
    private int guestId;
    private LocalDateTime date;
    private String hotelName;
    private int rating;
    private String comment;

    public ReviewView(int guestId, LocalDateTime date, String hotelName,int rating, String comment) {
        setRating(rating);
        setGuestId(guestId);
        setDate(date);
        setHotelName(hotelName);
        setComment(comment);
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
