package ExamenProg2.com.Prog2.Repository;


import ExamenProg2.com.Prog2.model.booking;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingCrud extends BookingDAO {
    private Connection connection;

    public BookingCrud(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<booking> getAllBooking() {
        List<booking> allBookings = new ArrayList<>();
        String sql = "SELECT * FROM booking";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                allBookings.add(new booking(
                        result.getInt("booking_id"),
                        result.getInt("customer_id"),
                        result.getInt("projection_id"),
                        result.getInt("room_id"),
                        result.getInt("number_of_reserved_places"),
                        result.getDate("date").toLocalDate(),
                        result.getFloat("paiment_status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allBookings;
    }

    @Override
    public void insertBooking(booking toInsert) {
        String sql = "INSERT INTO booking (customer_id, projection_id, room_id, number_of_reserved_places, date, paiment_status) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toInsert.getCustomer_id());
            preparedStatement.setInt(2, toInsert.getProjection_id());
            preparedStatement.setInt(3, toInsert.getRoom_id());
            preparedStatement.setInt(4, toInsert.getNumber_of_reserved_places());
            preparedStatement.setDate(5, Date.valueOf(toInsert.getDate()));
            preparedStatement.setFloat(6, toInsert.getPaiment_status());

            int insertBook = preparedStatement.executeUpdate();
            if (insertBook > 0) {
                System.out.println("Insertion réussie : " + insertBook);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public booking getIdBooking(int id) {
        String sql = "SELECT * FROM booking WHERE booking_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                return new booking(
                        result.getInt("booking_id"),
                        result.getInt("customer_id"),
                        result.getInt("projection_id"),
                        result.getInt("room_id"),
                        result.getInt("number_of_reserved_places"),
                        result.getDate("date").toLocalDate(),
                        result.getFloat("paiment_status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public booking updateBooking(int id, booking toUpdate) {
        String sql = "UPDATE booking SET customer_id=?, projection_id=?, room_id=?, number_of_reserved_places=?, date=?, paiment_status=? WHERE booking_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toUpdate.getCustomer_id());
            preparedStatement.setInt(2, toUpdate.getProjection_id());
            preparedStatement.setInt(3, toUpdate.getRoom_id());
            preparedStatement.setInt(4, toUpdate.getNumber_of_reserved_places());
            preparedStatement.setDate(5, Date.valueOf(toUpdate.getDate()));
            preparedStatement.setFloat(6, toUpdate.getPaiment_status());
            preparedStatement.setInt(7, id);

            int updateBook = preparedStatement.executeUpdate();
            if (updateBook > 0) {
                System.out.println("Mise à jour réussie : " + updateBook);
            }
            return toUpdate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<booking> deleteBooking(int id) {
        String sql = "DELETE FROM booking WHERE booking_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int deleteBook = preparedStatement.executeUpdate();
            if (deleteBook > 0) {
                System.out.println("Suppression réussie : " + deleteBook);
            }
            return getAllBooking();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
