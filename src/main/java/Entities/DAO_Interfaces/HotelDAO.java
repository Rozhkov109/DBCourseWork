package Entities.DAO_Interfaces;

import Entities.Classes.Hotel;
import java.util.List;

public interface HotelDAO {
    Hotel getHotelById(int id);
    List<Hotel> getAllHotels();
}
