package Entities.DAO_Implementation;

import Entities.Classes.Room;
import Entities.DAO_Interfaces.RoomDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {

    private Connection connection;

    private static final String SELECT_ALL_ROOMS_BY_HOTEL_ID = "SELECT * FROM hotelreservations.room WHERE Hotel_id = ?";
    private static final String SELECT_ALL_ROOMS = "SELECT * FROM hotelreservations.room";
    private static final String UPDATE_ROOM_STATUS = "{call room_update_status(?, ?)}";

    public RoomDAOImpl() {
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
    public List<Room> getAllRoomsById(int hotelId) {
        try {
            List<Room> roomList = new ArrayList<>();

            Statement statement = connection.createStatement();
            ResultSet setOfRooms = statement.executeQuery(SELECT_ALL_ROOMS_BY_HOTEL_ID);

            while (setOfRooms.next()) {
                roomList.add(new Room(
                        setOfRooms.getInt("Room_id"),
                        setOfRooms.getInt("Hotel_id"),
                        setOfRooms.getDouble("PricePerNight"),
                        setOfRooms.getString("Number"),
                        Room.RoomType.fromString(setOfRooms.getString("Type")),
                        Room.RoomStatus.fromString(setOfRooms.getString("Status")),
                        setOfRooms.getInt("OneSizeBed"),
                        setOfRooms.getInt("TwoSizeBed"),
                        setOfRooms.getInt("Capacity"),
                        setOfRooms.getString("Description")
                        ));
            }
            return roomList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Room> getAllRooms() {
        try {
            List<Room> roomList = new ArrayList<>();

            Statement statement = connection.createStatement();
            ResultSet setOfRooms = statement.executeQuery(SELECT_ALL_ROOMS);

            while (setOfRooms.next()) {
                roomList.add(new Room(
                        setOfRooms.getInt("Room_id"),
                        setOfRooms.getInt("Hotel_id"),
                        setOfRooms.getDouble("PricePerNight"),
                        setOfRooms.getString("Number"),
                        Room.RoomType.fromString(setOfRooms.getString("Type")),
                        Room.RoomStatus.fromString(setOfRooms.getString("Status")),
                        setOfRooms.getInt("OneSizeBed"),
                        setOfRooms.getInt("TwoSizeBed"),
                        setOfRooms.getInt("Capacity"),
                        setOfRooms.getString("Description")
                ));
            }
            return roomList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateRoomStatus(int roomId, Room.RoomStatus status) {
        try {
            PreparedStatement preparedRoomStatement = connection.prepareStatement(UPDATE_ROOM_STATUS);

            preparedRoomStatement.setInt(1, roomId);
            preparedRoomStatement.setString(2, status.getStatus());

            preparedRoomStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
