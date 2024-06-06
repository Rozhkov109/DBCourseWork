package Entities.DAO_Implementation;

import Entities.Classes.Guest;
import Entities.Classes.Reservation;
import Entities.Classes.Room;
import Entities.Classes.RoomsView;
import Entities.DAO_Interfaces.RoomsViewDAO;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoomsViewDAOImpl implements RoomsViewDAO {
    private Connection connection;

    private static final String SELECT_ALL_FROM_ROOMS_VIEW = "SELECT * FROM hotelreservations.hotel_rooms_sorted_by_end_date";
    private static final String UPDATE_ROOM_STATUS = "{call room_update_status(?, ?)}";

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


                roomsViewList.add(new RoomsView(hotelId,roomId,name,country,city,price,type,status,capacity,endDate));
            }
            return roomsViewList;
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateRoomsView() {
        try {
            List<RoomsView> roomsViewList = getRoomsView();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            for (RoomsView roomsView : roomsViewList) {
                LocalDateTime localDateTime;
                if (roomsView.getEndDate() == null) {
                    localDateTime = LocalDateTime.MIN;
                }
                else {
                    localDateTime = LocalDateTime.parse(roomsView.getEndDate(),formatter);
                }
                if ((localDateTime.isBefore(LocalDateTime.now()) || roomsView.getEndDate() == null) && roomsView.getRoomStatus().getStatus().equals(Room.RoomStatus.OCCUPIED.getStatus())) {

                    PreparedStatement preparedRoomStatement = connection.prepareStatement(UPDATE_ROOM_STATUS);
                    preparedRoomStatement.setInt(1, roomsView.getRoomId());
                    preparedRoomStatement.setString(2, Room.RoomStatus.AVAILABLE.getStatus());

                    preparedRoomStatement.execute();
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
