package Entities.Services;

import Entities.Classes.Room;
import Entities.DAO_Interfaces.RoomDAO;

import java.util.List;

public class RoomService {
    private RoomDAO roomDAO;

    public RoomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    List<Room> getAllRoomsById(int hotelId) {
        return roomDAO.getAllRoomsById(hotelId);
    }
}
