package Entities.Services;

import Entities.Classes.RoomsView;
import Entities.DAO_Interfaces.RoomsViewDAO;

import java.util.List;

public class RoomsViewService {
    private RoomsViewDAO roomsViewDAO;

    public RoomsViewService(RoomsViewDAO roomsViewDAO) {
        this.roomsViewDAO = roomsViewDAO;
    }

    public List<RoomsView> getRoomsView() {
        return roomsViewDAO.getRoomsView();
    }

    public void updateRoomsView() {
        roomsViewDAO.updateRoomsView();
    }
}
