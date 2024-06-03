package Entities.Classes;

public class Room {

    public enum Type {
        STANDART("Стандартний"),
        LUXURY("Люкс");

        private String type;

        Type(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }

    public enum Status {
        AVAILABLE("Доступний"),
        OCCUPIED("Зайнятий"),
        MAINTENANCE("Обслуговування");

        private String status;

        Status(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return status;
        }
    }

    private int id = -1;
    private int hotelID;
    private double pricePerNight;
    private String number;
    private Type type;
    private Status status;
    private int oneSizeBed;
    private int twoSizeBed;
    private int capacity;
    private String description;


    public Room(int hotelID, double pricePerNight, String number, Type type, Status status, int oneSizeBed, int twoSizeBed, String description) {
        setHotelID(hotelID);
        setPricePerNight(pricePerNight);
        setNumber(number);
        setType(type);
        setStatus(status);
        setOneSizeBed(oneSizeBed);
        setTwoSizeBed(twoSizeBed);
        setCapacity();
        setDescription(description);
    }

    public Room(int id, int hotelID, double pricePerNight, String number, Type type, Status status, int oneSizeBed, int twoSizeBed, String description) {
        setId(id);
        setHotelID(hotelID);
        setPricePerNight(pricePerNight);
        setNumber(number);
        setType(type);
        setStatus(status);
        setOneSizeBed(oneSizeBed);
        setTwoSizeBed(twoSizeBed);
        setCapacity();
        setDescription(description);
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getOneSizeBed() {
        return oneSizeBed;
    }

    public void setOneSizeBed(int oneSizeBed) {
        this.oneSizeBed = oneSizeBed;
    }

    public int getTwoSizeBed() {
        return twoSizeBed;
    }

    public void setTwoSizeBed(int twoSizeBed) {
        this.twoSizeBed = twoSizeBed;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity() {
        this.capacity = oneSizeBed + twoSizeBed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
