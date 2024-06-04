package Entities.DAO_Interfaces;

import java.time.LocalDateTime;


public interface OrderAndReservationDAO {
    void addOrderWithReservation(int guestId, int roomId, LocalDateTime startDate, LocalDateTime endDate, String comment);
    void deleteOrderWithReservation(int orderId);
}
