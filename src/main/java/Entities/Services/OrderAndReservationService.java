package Entities.Services;

import Entities.Classes.Reservation;
import Entities.DAO_Interfaces.OrderAndReservationDAO;

import java.time.LocalDateTime;
import java.util.List;

public class OrderAndReservationService {

    private OrderAndReservationDAO orderAndReservationDAO;

    public OrderAndReservationService(OrderAndReservationDAO orderAndReservationDAO) {
        this.orderAndReservationDAO = orderAndReservationDAO;
    }

    public void addOrderWithReservation(int guestId, int roomId, LocalDateTime startDate, LocalDateTime endDate, String comment) {
        orderAndReservationDAO.addOrderWithReservation(guestId,roomId,startDate,endDate,comment);
    }

    public void deleteOrderWithReservation(int orderId) {
        orderAndReservationDAO.deleteOrderWithReservation(orderId);
    }

    public List<Reservation> getAllReservations() {
        return orderAndReservationDAO.getAllReservations();
    }

    public void updateReservationsAndRoomsData() {
        orderAndReservationDAO.updateReservationsData();
    }
}
