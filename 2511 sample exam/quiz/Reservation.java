package quiz;

import java.time.LocalDate;

public class Reservation {
    private String reservationID;

    private Guest guest; // aggregation 1 to 1

    private Hotel hotel; // aggregation 1 to 1

    private Roomtype roomtype;

    private Room room; // aggregation 1 to 1

    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(
        String guestID,
        String hotelName,
        String roomType,
        LocalDate checkIn,
        LocalDate checkOut
    ) {
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

    public void changeHotel(String oldhotelName, String newHotelName) {
    }
    
    public void changeDate( LocalDate oldcheckIn, LocalDate oldcheckOut, LocalDate newcheckIn, LocalDate newcheckOut) {
    }

    public Roomtype requestRoomtype() {
        return null;
    }

    public void allocateRoom() {

    }
}
