package ExamenProg2.com.Prog2.Repository;

import ExamenProg2.com.Prog2.model.film;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class FilmCrud extends FilmDAO {
    private Connection connection;

    public FilmCrud(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<film> getAllFilm() {
        List<film> allFilms = new ArrayList<>();
        String sql = "SELECT * FROM film";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                allFilms.add(new film(
                        result.getInt("film_id"),
                        result.getString("title"),
                        result.getInt("duration"),
                        result.getString("gender")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allFilms;
    }

    @Override
    public void insertFilm(film toInsert) {
        String sql = "INSERT INTO film (title, duration, gender) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toInsert.getTitle());
            preparedStatement.setInt(2, toInsert.getDuration());
            preparedStatement.setString(3, toInsert.getGender());

            int insertfIlM = preparedStatement.executeUpdate();
            if (insertfIlM>0) {
                System.out.println("Insertion réussie : " + insertfIlM);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public film getIdFilm(int id) {
        String sql = "SELECT * FROM film WHERE film_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                return new film(
                        result.getInt("film_id"),
                        result.getString("title"),
                        result.getInt("duration"),
                        result.getString("gender")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public film updateFilm(int id, film toUpdate) {
        String sql = "UPDATE film SET title=?, duration=?, gender=? WHERE film_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toUpdate.getTitle());
            preparedStatement.setInt(2, toUpdate.getDuration());
            preparedStatement.setString(3, toUpdate.getGender());
            preparedStatement.setInt(4, id);

            int updateFilM = preparedStatement.executeUpdate();
            if (updateFilM> 0) {
                System.out.println("Mise à jour réussie : " + updateFilM);
            }
            return toUpdate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<film> deleteFilm(int id) {
        String sql = "DELETE FROM film WHERE film_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            int deleteFilM = preparedStatement.executeUpdate();

            if (deleteFilM > 0) {
                System.out.println("Suppression réussie : " + deleteFilM);
            }
            return getAllFilm();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
