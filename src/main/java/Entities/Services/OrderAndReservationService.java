package Entities.Services;

import Entities.DAO_Interfaces.OrderAndReservationDAO;

import java.time.LocalDateTime;

public class OrderAndReservationService {

    private OrderAndReservationDAO orderAndReservationDAO;

    public OrderAndReservationService(OrderAndReservationDAO orderAndReservationDAO) {
        this.orderAndReservationDAO = orderAndReservationDAO;
    }

    void addOrderWithReservation(int guestId, int roomId, LocalDateTime startDate, LocalDateTime endDate, String comment) {
        orderAndReservationDAO.addOrderWithReservation(guestId,roomId,startDate,endDate,comment);
    }

    void deleteOrderWithReservation(int orderId) {
        orderAndReservationDAO.deleteOrderWithReservation(orderId);
    }
}
