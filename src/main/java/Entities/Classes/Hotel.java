package Entities.Classes;

public class Hotel {
    private int id = -1;
    private String name;
    private int stars;
    private double rating;
    private String country;
    private String city;
    private String address;
    private String description;

    public Hotel(String name, int stars, double rating, String country, String city, String address, String description) {
        setName(name);
        setStars(stars);
        setRating(rating);
        setCountry(country);
        setCity(city);
        setAddress(address);
        setDescription(description);
    }

    public Hotel(int id, String name, int stars, double rating, String country, String city, String address, String description) {
        setId(id);
        setName(name);
        setStars(stars);
        setRating(rating);
        setCountry(country);
        setCity(city);
        setAddress(address);
        setDescription(description);
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
