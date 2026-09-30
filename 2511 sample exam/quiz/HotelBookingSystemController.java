package quiz;

import java.time.LocalDate;
import java.util.List;

public class HotelBookingSystemController {

    /**
     * Adds a new hotel to the system.
     *
     * @param name The hotel name
     * @param location The hotel location
     * @param rooms A list describing the room types in the hotel.
     *              Each value is one of "standard", "deluxe", or "suite".
     */
    public void addHotel(String name, String location, List<String> rooms) {
    }

    /**
     * Creates a new stay for a guest.
     *
     * @param guestID The guest identifier
     * @param hotelName The requested hotel
     * @param roomType "standard", "deluxe", or "suite"
     * @param checkIn The check-in date
     * @param checkOut The check-out date
     * @return The ID of the new reservation
     */
    public String createReservation(
        String guestID,
        String hotelName,
        String roomType,
        LocalDate checkIn,
        LocalDate checkOut
    ) {
        return null;
    }

    /**
     * Changes the dates of an existing reservation.
     *
     * @param reservationID The reservation identifier
     * @param newCheckIn The new check-in date
     * @param newCheckOut The new check-out date
     */
    public void changeReservationDates(
        String reservationID,
        LocalDate newCheckIn,
        LocalDate newCheckOut
    ) {
    }

    /**
     * Changes the requested room type for an existing reservation.
     *
     * @param reservationID The reservation identifier
     * @param newRoomType "standard", "deluxe", or "suite"
     */
    public void changeRoomType(
        String reservationID,
        String newRoomType
    ) {
    }

    /**
     * Cancels an existing reservation.
     *
     * @param reservationID The reservation identifier
     */
    public void cancelReservation(String reservationID) {
    }
}