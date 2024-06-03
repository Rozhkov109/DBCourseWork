package Entities;

import java.time.LocalDateTime;

public class Reservation {
    public enum Status {
        ACTIVE("Активне"),
        CANCELED("Завершене");

        private String status;

        Status(String status) {
            this.status = status;
        }

    }

    private int id = -1;
    private int orderID;
    private int roomID;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Status status;

    public Reservation(int orderID, int roomID, LocalDateTime startDate, LocalDateTime endDate, Status status) {
        setOrderID(orderID);
        setRoomID(roomID);
        setStartDate(startDate);
        setEndDate(endDate);
        setStatus(status);
    }

    public int getId() {
        return id;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
