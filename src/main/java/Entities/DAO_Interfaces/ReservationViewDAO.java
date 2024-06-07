package Entities.DAO_Interfaces;

import Entities.Classes.ReservationView;

import java.util.List;

public interface ReservationViewDAO {
    List<ReservationView> getReservationView(int guestId);
}
