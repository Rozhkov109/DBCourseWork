package Entities.Services;

import Entities.Classes.ReservationView;
import Entities.DAO_Interfaces.ReservationViewDAO;

import java.util.List;

public class ReservationViewService {
    private ReservationViewDAO reservationViewDAO;

    public ReservationViewService(ReservationViewDAO reservationViewDAO) {
        this.reservationViewDAO = reservationViewDAO;
    }

    public List<ReservationView> getReservationView(int guestId) {
        return reservationViewDAO.getReservationView(guestId);
    }
}
