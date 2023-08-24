package ExamenProg2.com.Prog2.Repository;


import ExamenProg2.com.Prog2.model.projection;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProjectionCrud extends ProjectionDAO {
    private Connection connection;

    public ProjectionCrud(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<projection> getAllProjection() {
        List<projection> allProjections = new ArrayList<>();
        String sql = "SELECT * FROM projection";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                allProjections.add(new projection(
                        result.getInt("projection_id"),
                        result.getInt("film_id"),
                        result.getInt("room_id"),
                        result.getDate("date").toLocalDate(),
                        result.getTime("start_time"),
                        result.getInt("duration")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProjections;
    }

    @Override
    public void insertProjection(projection toInsert) {
        String sql = "INSERT INTO projection (film_id, room_id, date, start_time, duration) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toInsert.getFilm_id());
            preparedStatement.setInt(2, toInsert.getRoom_id());
            preparedStatement.setDate(3, java.sql.Date.valueOf(toInsert.getDate()));
            preparedStatement.setTime(4, toInsert.getStart_time());
            preparedStatement.setInt(5, toInsert.getDuration());

            int insertProj = preparedStatement.executeUpdate();
            if (insertProj > 0) {
                System.out.println("Insertion réussie : " + insertProj);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public projection getIdProjection(int id) {
        String sql = "SELECT * FROM projection WHERE projection_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                return new projection(
                        result.getInt("projection_id"),
                        result.getInt("film_id"),
                        result.getInt("room_id"),
                        result.getDate("date").toLocalDate(),
                        result.getTime("start_time"),
                        result.getInt("duration")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public projection updateProjection(int id, projection toUpdate) {
        String sql = "UPDATE projection SET film_id=?, room_id=?, date=?, start_time=?, duration=? WHERE projection_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toUpdate.getFilm_id());
            preparedStatement.setInt(2, toUpdate.getRoom_id());
            preparedStatement.setDate(3, java.sql.Date.valueOf(toUpdate.getDate()));
            preparedStatement.setTime(4, toUpdate.getStart_time());
            preparedStatement.setInt(5, toUpdate.getDuration());
            preparedStatement.setInt(6, id);

            int updateProj = preparedStatement.executeUpdate();
            if (updateProj > 0) {
                System.out.println("Mise à jour réussie : " + updateProj);
            }
            return toUpdate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<projection> deleteProjection(int id) {
        String sql = "DELETE FROM projection WHERE projection_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int deleteProj = preparedStatement.executeUpdate();
            if (deleteProj > 0) {
                System.out.println("Suppression réussie : " + deleteProj);
            }
            return getAllProjection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
