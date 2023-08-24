package ExamenProg2.com.Prog2.Service;

import ExamenProg2.com.Prog2.Repository.BookingDAO;
import ExamenProg2.com.Prog2.model.booking;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private BookingDAO bookingDAO;


    public BookingService(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    public List<booking> getAllBookings() {
        return bookingDAO.getAllBooking();
    }

    public void insertBookings(booking toInsert) {
        bookingDAO.insertBooking(toInsert);
    }

    public booking getIdBookings(int id) {
        return bookingDAO.getIdBooking(id);
    }

    public booking updateBookings(int id, booking toUpdate) {
        return bookingDAO.updateBooking(id, toUpdate);
    }

    public List<booking> deleteBookings(int id) {
        return bookingDAO.deleteBooking(id);
    }
}
