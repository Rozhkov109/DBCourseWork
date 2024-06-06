package Entities.DAO_Interfaces;

import Entities.Classes.Reservation;

import java.time.LocalDateTime;
import java.util.List;


public interface OrderAndReservationDAO {
    void addOrderWithReservation(int guestId, int roomId, LocalDateTime startDate, LocalDateTime endDate, String comment);
    void deleteOrderWithReservation(int orderId);
    List<Reservation> getAllReservations();
    void updateReservationsData();
}
