package quiz;

import java.time.LocalDate;
import java.util.List;

public class Itinerary {
    private List<Reservation> reservations; // composition 1 to 1..*

    public String createReservation(
        String guestID,
        String hotelName,
        String roomType,
        LocalDate checkIn,
        LocalDate checkOut
    ) {
        return null;
    }

    public void changeReservationDates(
        String reservationID,
        LocalDate newCheckIn,
        LocalDate newCheckOut
    ) {
    }

    public void changeRoomType(
        String reservationID,
        String newRoomType
    ) {
    }

    public void cancelReservation(String reservationID) {
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
