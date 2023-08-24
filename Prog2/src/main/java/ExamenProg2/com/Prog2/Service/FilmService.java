package ExamenProg2.com.Prog2.Service;

import ExamenProg2.com.Prog2.Repository.FilmDAO;
import ExamenProg2.com.Prog2.model.film;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    private FilmDAO filmDAO;
    public FilmService(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    public List<film> getAllFilms() {
      return filmDAO.getAllFilm();
    }

    public void insertFilms(film toInsert) {
        filmDAO.insertFilm(toInsert);
    }

    public film getIdFilms(int id) {
       return  filmDAO.getIdFilm(id);
    }

    public film updateFilms(int id, film toUpdate) {

       return  filmDAO.updateFilm(id,toUpdate);
    }

    public List<film> deleteFilms(int id) {
       return filmDAO.deleteFilm(id);
    }
}
