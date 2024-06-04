package Entities.DAO_Implementation;

import Entities.Classes.Guest;
import Entities.Classes.Hotel;
import Entities.DAO_Interfaces.HotelDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAOImpl implements HotelDAO {

    private Connection connection;

    private static final String SELECT_ALL_HOTELS = "SELECT * FROM hotelreservations.hotel";

    public HotelDAOImpl() {
        try {
            String URL = "jdbc:mysql://localhost:3306/hotelreservations";
            String USER = "root";
            String PASSWORD = "";
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Hotel> getAllHotels() {
        try {
            List<Hotel> hotelList = new ArrayList<>();

            Statement statement = connection.createStatement();
            ResultSet setOfHotels = statement.executeQuery(SELECT_ALL_HOTELS);

            while (setOfHotels.next()) {
                hotelList.add(new Hotel(
                        setOfHotels.getString("Name"),
                        setOfHotels.getInt("Stars"),
                        setOfHotels.getDouble("Rating"),
                        setOfHotels.getString("Country"),
                        setOfHotels.getString("City"),
                        setOfHotels.getString("Address"),
                        setOfHotels.getString("Description")));
            }
            return hotelList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
