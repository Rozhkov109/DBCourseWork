package Entities.DAO_Implementation;

import Entities.Classes.Reservation;
import Entities.Classes.Room;
import Entities.DAO_Interfaces.OrderAndReservationDAO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderAndReservationDAOImpl implements OrderAndReservationDAO {

    private Connection connection;

    private final String ADD_ORDER_WITH_RESERVATION = "{call guest_add_order_with_reservation(?, ?, ?, ?, ?)}";
    private final String DELETE_ORDER_WITH_RESERVATION = "DELETE FROM hotelreservations.order WHERE Order_id = ?";
    private static final String SELECT_ALL_RESERVATIONS = "SELECT * FROM hotelreservations.reservation";
    private static final String UPDATE_RESERVATION_STATUS = "{call reservation_update_status(?, ?)}";

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

    @Override
    public List<Reservation> getAllReservations() {
        try {
            List<Reservation> reservationList = new ArrayList<>();

            Statement statement = connection.createStatement();
            ResultSet setOfReservations = statement.executeQuery(SELECT_ALL_RESERVATIONS);

            while (setOfReservations.next()) {
                reservationList.add(new Reservation(
                        setOfReservations.getInt("Reservation_id"),
                        setOfReservations.getInt("Order_id"),
                        setOfReservations.getInt("Room_id"),
                        setOfReservations.getTimestamp("StartDate").toLocalDateTime(),
                        setOfReservations.getTimestamp("EndDate").toLocalDateTime(),
                        Reservation.ReservationStatus.fromString(setOfReservations.getString("Status"))
                ));
            }
            return reservationList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateReservationsData() {
        try {
            List<Reservation> reservationsList = getAllReservations();

            for (Reservation reservation : reservationsList) {
                if (reservation.getEndDate().isBefore(LocalDateTime.now()) || reservation.getEndDate() == null) {
                    PreparedStatement preparedReservationStatement = connection.prepareStatement(UPDATE_RESERVATION_STATUS);
                    preparedReservationStatement.setInt(1, reservation.getId());
                    preparedReservationStatement.setString(2, Reservation.ReservationStatus.COMPLETED.getStatus());

                    preparedReservationStatement.execute();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
