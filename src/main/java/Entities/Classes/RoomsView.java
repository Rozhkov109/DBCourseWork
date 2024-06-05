package Entities.Classes;

import java.time.LocalDateTime;

public class RoomsView {
    private int hotelId;

    private int roomId;
    private String name;
    private String country;
    private String city;
    private double pricePerNight;
    private Room.RoomType roomType;
    private Room.RoomStatus roomStatus;
    private int capacity;
    private String endDate;

    public RoomsView(int hotelId, int roomId, String name, String country, String city, double pricePerNight, Room.RoomType roomType, Room.RoomStatus roomStatus, int capacity, String endDate) {
        setRoomId(roomId);
        setHotelId(hotelId);
        setName(name);
        setCountry(country);
        setCity(city);
        setPricePerNight(pricePerNight);
        setRoomType(roomType);
        setRoomStatus(roomStatus);
        setCapacity(capacity);
        setEndDate(endDate);
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Room.RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(Room.RoomType roomType) {
        this.roomType = roomType;
    }

    public Room.RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Room.RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
