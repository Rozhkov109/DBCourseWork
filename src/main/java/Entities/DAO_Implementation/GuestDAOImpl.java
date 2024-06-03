package Entities.DAO_Implementation;

import Entities.Classes.Guest;
import Entities.DAO_Interfaces.GuestDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDAOImpl implements GuestDAO {
    private Connection connection;

    private final String ADD_GUEST = "{call guest_add(?, ?, ?, ?, ?, ?, ?)}";
    private static final String SELECT_GUEST_BY_ID = "SELECT * FROM hotelreservations.guest WHERE Guest_id = ?";
    private static final String SELECT_GUEST_BY_EMAIL = "SELECT * FROM hotelreservations.guest WHERE Email = ?";
    private static final String SELECT_ALL_GUESTS = "SELECT * FROM hotelreservations.guest";

    public GuestDAOImpl() {
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
    public void addGuest(Guest guest) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_GUEST);
            preparedStatement.setString(1, guest.getFirstName());
            preparedStatement.setString(2, guest.getLastName());
            preparedStatement.setDate(3, Date.valueOf(guest.getBirthDate()));
            preparedStatement.setString(4, guest.getPhoneNumber());
            preparedStatement.setString(5, guest.getEmail());
            preparedStatement.setString(6, guest.getPassportNumber());
            preparedStatement.setString(7, guest.getPassword());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Guest getGuestById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GUEST_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet guestSet = preparedStatement.executeQuery();
            guestSet.next(); // Перехід на перший рядок (початкове значення перед першим рядком)

            return new Guest(
                    guestSet.getInt("Guest_id"),
                    guestSet.getString("FirstName"),
                    guestSet.getString("SecondName"),
                    guestSet.getDate("BirthDate").toLocalDate(),
                    guestSet.getString("PhoneNumber"),
                    guestSet.getString("Email"),
                    guestSet.getString("PassportNumberHash"),
                    guestSet.getString("PasswordHash"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Guest getGuestByEmail(String email) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GUEST_BY_EMAIL);
            preparedStatement.setString(1, email);

            ResultSet guestSet = preparedStatement.executeQuery();
            guestSet.next(); // Перехід на перший рядок (початкове значення перед першим рядком)

            return new Guest(
                    guestSet.getInt("Guest_id"),
                    guestSet.getString("FirstName"),
                    guestSet.getString("SecondName"),
                    guestSet.getDate("BirthDate").toLocalDate(),
                    guestSet.getString("PhoneNumber"),
                    guestSet.getString("Email"),
                    guestSet.getString("PassportNumberHash"),
                    guestSet.getString("PasswordHash"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Guest> getAllGuests() {
        try {
            List<Guest> guestList = new ArrayList<>();

            Statement statement = connection.createStatement();
            ResultSet setOfGuests = statement.executeQuery(SELECT_ALL_GUESTS);

            while (setOfGuests.next()) {
                guestList.add(new Guest(
                        setOfGuests.getInt("Guest_id"),
                        setOfGuests.getString("FirstName"),
                        setOfGuests.getString("SecondName"),
                        setOfGuests.getDate("BirthDate").toLocalDate(),
                        setOfGuests.getString("PhoneNumber"),
                        setOfGuests.getString("Email"),
                        setOfGuests.getString("PassportNumberHash"),
                        setOfGuests.getString("PasswordHash")));
            }
            return guestList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
