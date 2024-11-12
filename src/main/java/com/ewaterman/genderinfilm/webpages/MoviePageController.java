package com.ewaterman.genderinfilm.webpages;

import com.ewaterman.genderinfilm.common.BooleanAnswer;
import com.ewaterman.genderinfilm.movies.Movie;
import com.ewaterman.genderinfilm.movies.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MoviePageController {

    private final MovieService movieService;

    public MoviePageController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    String indexPage(@PathVariable Long id, Model model) {

        // Get movie info and results
        Movie movie = movieService.findById(id).orElseThrow(() -> new IllegalArgumentException("Movie not found with id: " + id));
        model.addAttribute("movie", movie);

        // Get TMDB stats for the movie
        // TODO: Get TMDB info via API.
        String tmdbId = movie.getTmdbId();
        model.addAttribute("tmdb", tmdbId);

        return "movie";
    }

    @GetMapping("/create")
    String createPage(Model model) {
        Movie movie = movieService.initMovieWithQuestions();

        model.addAttribute("movie", movie);
        model.addAttribute("answerTypes", BooleanAnswer.values());
        return "movie-edit";
    }

    @GetMapping("/{id}/update")
    String updatePage(@PathVariable long id, Model model) {
        Movie movie = movieService.findByIdAndPopulate(id)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found with id: " + id));

        model.addAttribute("movie", movie);
        model.addAttribute("answerTypes", BooleanAnswer.values());
        return "movie-edit";
    }

    @PostMapping("/save")
    public String saveOperation(@ModelAttribute("movie") Movie movie) {
        long id = movieService.save(movie).getId();
        return "redirect:/movies/" + id;
    }

    @DeleteMapping("/{id}")
    public String deleteOperation(@PathVariable long id) {
        movieService.delete(id);
        return "redirect:/";
    }
}
