package Entities.Classes;

import java.time.LocalDateTime;

public class Review {
    private int id = -1;
    private int guestID;
    private int hotelID;
    private LocalDateTime date;
    private int rating;
    private String comment;

    public Review(int guestID, int hotelID, LocalDateTime date, int rating, String comment) {
        setGuestID(guestID);
        setHotelID(hotelID);
        setDate(date);
        setRating(rating);
        setComment(comment);
    }

    public Review(int id, int guestID, int hotelID, LocalDateTime date, int rating, String comment) {
        setId(id);
        setGuestID(guestID);
        setHotelID(hotelID);
        setDate(date);
        setRating(rating);
        setComment(comment);
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
