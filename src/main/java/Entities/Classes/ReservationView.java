package Entities.Classes;

import java.time.LocalDateTime;

public class ReservationView {
    private int guestId;
    private int orderId;
    private String hotelName;
    private String city;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double price;

    public ReservationView(int guestId, int orderId, String hotelName, String city, LocalDateTime startDate, LocalDateTime endDate, double price) {
        setGuestId(guestId);
        setOrderId(orderId);
        setHotelName(hotelName);
        setCity(city);
        setStartDate(startDate);
        setEndDate(endDate);
        setPrice(price);
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
