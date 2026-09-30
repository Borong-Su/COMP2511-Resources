package quiz;

import java.time.LocalDate;
import java.util.List;

public class Guest {
    private String guestID;

    private List<Itinerary> itineraries; // composition 1 to 1..*

    public void addItinerary(
        String reservationID,
        String hotelName,
        String roomType,
        LocalDate checkIn,
        LocalDate checkOut
    ) {
    }

    public void cancelItinerary(String reservationID) {
    }

    public void changeHotel(String reservationID, String oldhotelName, String newHotelName) {
    }
    
    public void changeDate(String reservationID, LocalDate oldcheckIn, LocalDate oldcheckOut, LocalDate newcheckIn, LocalDate newcheckOut) {
    }

    public Roomtype requestRoomtype(String reservationID) {
        return null;
    }

    public void allocateRoom(String reservationID) {

    }
}
