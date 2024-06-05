package Entities.DAO_Implementation;

import Entities.Classes.Guest;
import Entities.Classes.Room;
import Entities.Classes.RoomsView;
import Entities.DAO_Interfaces.RoomsViewDAO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RoomsViewDAOImpl implements RoomsViewDAO {
    private Connection connection;

    private static final String SELECT_ALL_FROM_ROOMS_VIEW = "SELECT * FROM hotelreservations.hotel_rooms_sorted_by_end_date";

    public RoomsViewDAOImpl() {
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
    public List<RoomsView> getRoomsView() throws NullPointerException {
        try {
            List<RoomsView> roomsViewList = new ArrayList<>();

            Statement statement = connection.createStatement();
            ResultSet setOfRoomsView = statement.executeQuery(SELECT_ALL_FROM_ROOMS_VIEW);

            while (setOfRoomsView.next()) {

               int hotelId = setOfRoomsView.getInt("Hotel_id");
               int roomId = setOfRoomsView.getInt("Room_id");
               String name = setOfRoomsView.getString("Name");
               String country = setOfRoomsView.getString("Country");
               String city = setOfRoomsView.getString("City");
               double price = setOfRoomsView.getDouble("PricePerNight");
               Room.RoomType type = Room.RoomType.fromString(setOfRoomsView.getString("Type"));
               Room.RoomStatus status = Room.RoomStatus.fromString(setOfRoomsView.getString("Status"));
               int capacity = setOfRoomsView.getInt("Capacity");
               String endDate = setOfRoomsView.getString("EndDate");
               if (endDate == null) { endDate = "Вільна"; }


                roomsViewList.add(new RoomsView(hotelId,roomId,name,country,city,price,type,status,capacity,endDate));
            }
            return roomsViewList;
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
