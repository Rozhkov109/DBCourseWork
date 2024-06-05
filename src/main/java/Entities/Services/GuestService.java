package Entities.Services;

import Entities.Classes.Guest;
import Entities.DAO_Interfaces.GuestDAO;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class GuestService {
    private GuestDAO guestDAO;

    public GuestService(GuestDAO guestDAO) {
        this.guestDAO = guestDAO;
    }

    public void register(Guest guest) {
        if (guest != null) {
            guestDAO.addGuest(guest);
        }
    }

    public Guest login(String email, String password) {
        Guest guest = guestDAO.getGuestByEmail(email);

        String passwordHash = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

        if (guest != null && guest.getPassword().equals(passwordHash)) {
            return guest;
        }
        return null;
    }

    public Guest getGuestById(int guestId) {
        return guestDAO.getGuestById(guestId);
    }

    public List<Guest> getAllGuests() {
        return guestDAO.getAllGuests();
    }
}
