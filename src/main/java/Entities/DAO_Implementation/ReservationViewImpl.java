package Entities.DAO_Implementation;

import Entities.Classes.Guest;
import Entities.Classes.ReservationView;
import Entities.DAO_Interfaces.ReservationViewDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationViewImpl implements ReservationViewDAO {

    private Connection connection;

    private static final String SELECT_ALL_FROM_RESERVATION_VIEW = "SELECT * FROM hotelreservations.guest_all_reservations";

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
    public List<ReservationView> getReservationView() {
        try {
            List<ReservationView> reservationViewList = new ArrayList<>();

            Statement statement = connection.createStatement();
            ResultSet setOfReservationView = statement.executeQuery(SELECT_ALL_FROM_RESERVATION_VIEW);

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
