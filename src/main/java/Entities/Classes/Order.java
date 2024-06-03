package Entities.Classes;

import java.time.LocalDateTime;

public class Order {
    public enum Status {
        CONFIRMED("Підтверджено"),
        CANCELED("Скасовано");

        private String status;

        Status(String status) {
            this.status = status;
        }
    }

    private int id = -1;
    private int guestID;
    private double price;
    private LocalDateTime date;
    private Status status;
    private String comment;

    public Order(int guestID, double price, LocalDateTime date, Status status, String comment) {
        setGuestID(guestID);
        setPrice(price);
        setDate(date);
        setStatus(status);
        setComment(comment);
    }

    public Order(int id, int guestID, double price, LocalDateTime date, Status status, String comment) {
        setId(id);
        setGuestID(guestID);
        setPrice(price);
        setDate(date);
        setStatus(status);
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
