package Entities.DAO_Interfaces;

import Entities.Classes.Guest;

import java.util.List;

public interface GuestDAO {
    void addGuest(Guest guest);
    Guest getGuestById(int id);
    Guest getGuestByEmail(String email);
    List<Guest> getAllGuests();
}
