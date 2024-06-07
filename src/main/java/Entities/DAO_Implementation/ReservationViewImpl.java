package Entities.DAO_Implementation;

import Entities.Classes.Guest;
import Entities.Classes.ReservationView;
import Entities.DAO_Interfaces.ReservationViewDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationViewImpl implements ReservationViewDAO {

    private Connection connection;

    private static final String SELECT_ALL_FROM_RESERVATION_VIEW_BY_GUEST_ID = "SELECT * FROM hotelreservations.guest_all_reservations WHERE Guest_id = ?";

    public ReservationViewImpl() {
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
    public List<ReservationView> getReservationView(int guestId) {
        try {
            List<ReservationView> reservationViewList = new ArrayList<>();

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_RESERVATION_VIEW_BY_GUEST_ID);
            preparedStatement.setInt(1, guestId);

            ResultSet setOfReservationView = preparedStatement.executeQuery();

            while (setOfReservationView.next()) {
                reservationViewList.add(new ReservationView(
                        setOfReservationView.getInt("Guest_id"),
                        setOfReservationView.getInt("Order_id"),
                        setOfReservationView.getString("HotelName"),
                        setOfReservationView.getString("City"),
                        setOfReservationView.getTimestamp("StartDate").toLocalDateTime(),
                        setOfReservationView.getTimestamp("EndDate").toLocalDateTime(),
                        setOfReservationView.getDouble("Price")));
            }
            return reservationViewList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
