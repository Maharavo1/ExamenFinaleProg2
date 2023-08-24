package ExamenProg2.com.Prog2.Controller;

import ExamenProg2.com.Prog2.Service.BookingService;
import ExamenProg2.com.Prog2.model.booking;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    private BookingService bookingService;


    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/booking")
    public List<booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping("/bookingInsert")
    public void insertBooking(@RequestBody booking toInsert) {
        bookingService.insertBookings(toInsert);
    }

    @GetMapping("/bookingId/{id}")
    public booking getBookingById(@PathVariable int id) {
        return bookingService.getIdBookings(id);
    }

    @PutMapping("/bookingUpdate/{id}")
    public booking updateBooking(@PathVariable int id, @RequestBody booking toUpdate) {
        return bookingService.updateBookings(id, toUpdate);
    }

    @DeleteMapping("/bookingDelete/{id}")
    public List<booking> deleteBooking(@PathVariable int id) {
        return bookingService.deleteBookings(id);
    }
}
