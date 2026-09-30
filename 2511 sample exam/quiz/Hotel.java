package quiz;

import java.time.LocalDate;
import java.util.List;

public class Hotel {
    private String hotelName;

    private String location;

    private List<Room> rooms; // composition 1 to 1..*

    private List<Reservation> reservations; // aggregation 1 to 1..*

    public Hotel(String hotelName) {
    }

    public Boolean getPerferRoom(Roomtype roomtype) {
        return null;
    }

    public void addReservation(String reservationID, LocalDate CheckIn, LocalDate CheckOut) {
    }

    public void cancelReservation(String reservationID) {
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

}
