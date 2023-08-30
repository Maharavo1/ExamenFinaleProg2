package ExamenProg2.com.Prog2.Repository;


import ExamenProg2.com.Prog2.model.film;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public abstract class FilmDAO {
    public abstract List<film> getAllFilm();
    public abstract  void insertFilm(film toInsert);
    public abstract film getIdFilm(int id);
    public abstract film updateFilm(int id, film toUpdate);
    public abstract List<film> deleteFilm(int id);
}
