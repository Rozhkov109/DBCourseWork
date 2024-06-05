package Entities.Classes;

import java.time.LocalDateTime;

public class Order {
    public enum OrderStatus {
        CONFIRMED("Confirmed"),
        CANCELED("Cancelled");

        private String status;

        public static OrderStatus fromString(String status) {
            for (OrderStatus s : OrderStatus.values()) {
                if (s.status.equalsIgnoreCase(status)) {
                    return s;
                }
            }
            return null;
        }

        OrderStatus(String status) {
            this.status = status;
        }
    }

    private int id = -1;
    private int guestID;
    private double price;
    private LocalDateTime date;
    private OrderStatus orderStatus;
    private String comment;

    public Order(int guestID, double price, LocalDateTime date, OrderStatus orderStatus, String comment) {
        setGuestID(guestID);
        setPrice(price);
        setDate(date);
        setOrderStatus(orderStatus);
        setComment(comment);
    }

    public Order(int id, int guestID, double price, LocalDateTime date, OrderStatus orderStatus, String comment) {
        setId(id);
        setGuestID(guestID);
        setPrice(price);
        setDate(date);
        setOrderStatus(orderStatus);
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
