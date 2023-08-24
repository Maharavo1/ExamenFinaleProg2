package ExamenProg2.com.Prog2.Repository;

import ExamenProg2.com.Prog2.model.booking;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public abstract class BookingDAO {
    public abstract List<booking> getAllBooking();
    public abstract  void insertBooking(booking toInsert);
    public abstract booking getIdBooking(int id);
    public abstract booking updateBooking(int id, booking toUpdate);
    public abstract List<booking> deleteBooking(int id);
}
