package Entities.Classes;

import java.time.LocalDateTime;

public class Reservation {
    public enum ReservationStatus {
        ACTIVE("Active"),
        COMPLETED("Completed");

        private String status;

        public static ReservationStatus fromString(String status) {
            for (ReservationStatus s : ReservationStatus.values()) {
                if (s.status.equalsIgnoreCase(status)) {
                    return s;
                }
            }
            return null;
        }

        ReservationStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }

    private int id = -1;
    private int orderID;
    private int roomID;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private ReservationStatus reservationStatus;

    public Reservation(int orderID, int roomID, LocalDateTime startDate, LocalDateTime endDate, ReservationStatus reservationStatus) {
        setOrderID(orderID);
        setRoomID(roomID);
        setStartDate(startDate);
        setEndDate(endDate);
        setStatus(reservationStatus);
    }

    public Reservation(int id, int orderID, int roomID, LocalDateTime startDate, LocalDateTime endDate, ReservationStatus reservationStatus) {
        setId(id);
        setOrderID(orderID);
        setRoomID(roomID);
        setStartDate(startDate);
        setEndDate(endDate);
        setStatus(reservationStatus);
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
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

    public ReservationStatus getStatus() {
        return reservationStatus;
    }

    public void setStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
