package ExamenProg2.com.Prog2.Controller;

import ExamenProg2.com.Prog2.Service.FilmService;
import ExamenProg2.com.Prog2.model.film;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {
    private FilmService filmService;


    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/film")
    public List<film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @PostMapping("/filmInsert")
    public void insertFilm(@RequestBody film toInsert) {
        filmService.insertFilms(toInsert);
    }

    @GetMapping("/filmId/{id}")
    public film getFilmById(@PathVariable int id) {
        return filmService.getIdFilms(id);
    }

    @PutMapping("/filmUpdate/{id}")
    public film updateFilm(@PathVariable int id, @RequestBody film toUpdate) {
        return filmService.updateFilms(id, toUpdate);
    }

    @DeleteMapping("/filmDelete/{id}")
    public List<film> deleteFilm(@PathVariable int id) {
        return filmService.deleteFilms(id);
    }
}
