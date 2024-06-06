package Entities.Classes;

public class Room {

    public enum RoomType {
        STANDART("Standard"),
        LUXURY("Luxury");

        private String type;

        RoomType(String type) {
            this.type = type;
        }

        public static RoomType fromString(String type) {
            for (RoomType t : RoomType.values()) {
                if (t.type.equalsIgnoreCase(type)) {
                    return t;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return type;
        }
    }

    public enum RoomStatus {
        AVAILABLE("Available"),
        OCCUPIED("Occupied"),
        MAINTENANCE("Maintenance");

        private String status;

        RoomStatus(String status) {
            this.status = status;
        }

        public static RoomStatus fromString(String status) {
            for (RoomStatus s : RoomStatus.values()) {
                if (s.status.equalsIgnoreCase(status)) {
                    return s;
                }
            }
            return null;
        }

        public String getStatus() {
            return status;
        }
    }

    private int id = -1;
    private int hotelID;
    private double pricePerNight;
    private String number;
    private RoomType roomType;
    private RoomStatus roomStatus;
    private int oneSizeBed;
    private int twoSizeBed;
    private int capacity;
    private String description;


    public Room(int hotelID, double pricePerNight, String number, RoomType roomType, RoomStatus roomStatus, int oneSizeBed, int twoSizeBed, String description) {
        setHotelID(hotelID);
        setPricePerNight(pricePerNight);
        setNumber(number);
        setType(roomType);
        setStatus(roomStatus);
        setOneSizeBed(oneSizeBed);
        setTwoSizeBed(twoSizeBed);
        setCapacity();
        setDescription(description);
    }

    public Room(int id, int hotelID, double pricePerNight, String number, RoomType roomType, RoomStatus roomStatus, int oneSizeBed, int twoSizeBed, int capacity, String description) {
        setId(id);
        setHotelID(hotelID);
        setPricePerNight(pricePerNight);
        setNumber(number);
        setType(roomType);
        setStatus(roomStatus);
        setOneSizeBed(oneSizeBed);
        setTwoSizeBed(twoSizeBed);
        setCapacity(capacity);
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

    public RoomType getType() {
        return roomType;
    }

    public void setType(RoomType roomType) {
        this.roomType = roomType;
    }

    public RoomStatus getStatus() {
        return roomStatus;
    }

    public void setStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
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

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
