package ExamenProg2.com.Prog2.Repository;

import ExamenProg2.com.Prog2.model.room;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Repository
public class RoomCrud extends RoomDAO {
    private Connection connection;

    public RoomCrud(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<room> getAllRoom() {
        List<room> allRooms = new ArrayList<>();
        String sql = "SELECT * FROM room";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                allRooms.add(new room(
                        result.getInt("room_id"),
                        result.getString("name"),
                        result.getInt("capacity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allRooms;
    }

    @Override
    public List<room> getAvailableRoom(LocalDateTime dateTime) {
        List<room> availableRooms = new ArrayList<>();
        Timestamp timestamp = Timestamp.valueOf(dateTime);

        String sql = "SELECT DISTINCT r.room_id, r.name, r.capacity " +
                "FROM room r " +
                "LEFT JOIN booking b ON r.room_id = b.room_id " +
                "WHERE ? NOT BETWEEN b.date AND (b.date + INTERVAL b.duration HOUR)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setTimestamp(1, timestamp);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                availableRooms.add(new room(
                        result.getInt("room_id"),
                        result.getString("name"),
                        result.getInt("capacity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return availableRooms;
    }


    @Override
    public void insertRoom(room toInsert) {
        String sql = "INSERT INTO room (name, capacity) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toInsert.getName());
            preparedStatement.setInt(2, toInsert.getCapacity());

            int insertRom = preparedStatement.executeUpdate();
            if (insertRom > 0) {
                System.out.println("Insertion réussie : " + insertRom);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public room getIdRoom(int id) {
        String sql = "SELECT * FROM room WHERE room_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                return new room(
                        result.getInt("room_id"),
                        result.getString("name"),
                        result.getInt("capacity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public room updateRoom(int id, room toUpdate) {
        String sql = "UPDATE room SET name=?, capacity=? WHERE room_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toUpdate.getName());
            preparedStatement.setInt(2, toUpdate.getCapacity());
            preparedStatement.setInt(3, id);

            int updateRom = preparedStatement.executeUpdate();
            if (updateRom > 0) {
                System.out.println("Mise à jour réussie : " + updateRom);
            }
            return toUpdate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<room> deleteRoom(int id) {
        String sql = "DELETE FROM room WHERE room_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int deleteRom = preparedStatement.executeUpdate();
            if (deleteRom > 0) {
                System.out.println("Suppression réussie : " + deleteRom);
            }
            return getAllRoom();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
