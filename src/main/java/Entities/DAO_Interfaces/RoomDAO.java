package Entities.DAO_Interfaces;

import Entities.Classes.Room;

import java.util.List;

public interface RoomDAO {
    List<Room> getAllRoomsById(int hotelId);
    List<Room> getAllRooms();
    void updateRoomStatus(int roomId,Room.RoomStatus status);
}
