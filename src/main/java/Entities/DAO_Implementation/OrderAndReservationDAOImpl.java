package Entities.DAO_Implementation;

import Entities.DAO_Interfaces.OrderAndReservationDAO;

import java.sql.*;
import java.time.LocalDateTime;

public class OrderAndReservationDAOImpl implements OrderAndReservationDAO {

    private Connection connection;

    private final String ADD_ORDER_WITH_RESERVATION = "{call guest_add_order_with_reservation(?, ?, ?, ?, ?)}";
    private final String DELETE_ORDER_WITH_RESERVATION = "DELETE FROM hotelreservations.order WHERE Order_id = ?";

    public OrderAndReservationDAOImpl() {
        try {
            String URL = "jdbc:mysql://localhost:3306/hotelreservations";
            String USER = "root";
            String PASSWORD = "";
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addOrderWithReservation(int guestId, int roomId, LocalDateTime startDate, LocalDateTime endDate, String comment) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_ORDER_WITH_RESERVATION);
            preparedStatement.setInt(1, guestId);
            preparedStatement.setInt(2, roomId);
            preparedStatement.setTimestamp(3, Timestamp.valueOf(startDate));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(endDate));
            preparedStatement.setString(5, comment);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteOrderWithReservation(int orderId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_WITH_RESERVATION);
            preparedStatement.setInt(1, orderId);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
