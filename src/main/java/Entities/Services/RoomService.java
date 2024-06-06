package Entities.Services;

import Entities.Classes.Room;
import Entities.DAO_Interfaces.RoomDAO;

import java.util.List;

public class RoomService {
    private RoomDAO roomDAO;

    public RoomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public List<Room> getAllRoomsById(int hotelId) {
        return roomDAO.getAllRoomsById(hotelId);
    }

    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    public void updateRoomStatus(int roomId, Room.RoomStatus status) {
        roomDAO.updateRoomStatus(roomId,status);
    }
}
