package Entities.Services;

import Entities.Classes.Hotel;
import Entities.DAO_Interfaces.HotelDAO;

import java.util.List;

public class HotelService {
    private HotelDAO hotelDAO;

    public HotelService(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

   public List<Hotel> getAllHotels() {
        return hotelDAO.getAllHotels();
   }
}
