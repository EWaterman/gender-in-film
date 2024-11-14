package com.ewaterman.genderinfilm;

import com.ewaterman.genderinfilm.characters.Character;
import com.ewaterman.genderinfilm.common.BooleanAnswer;
import com.ewaterman.genderinfilm.movies.Movie;
import com.ewaterman.genderinfilm.movies.MovieQuestion;
import com.ewaterman.genderinfilm.movies.MovieQuestionType;
import com.ewaterman.genderinfilm.movies.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.ListUtils;

import java.util.List;

/**
 * This will get deleted eventually but it loads some test data for us to play with
 */
@Component
public class TempDataLoader implements CommandLineRunner {

	private final MovieService movieService;

	public TempDataLoader(MovieService movieService) {
		this.movieService = movieService;
	}

	@Override
	public void run(String... args) {
		List<Movie> movies = movieService.findByNameIgnoreCaseContaining("Barbie");
		if (!ListUtils.isEmpty(movies)) {
			return;
		}

		Movie movie = Movie.builder()
				.name("Barbie")
				.tmdbId("1")
				.build();

		movie.setQuestions(List.of(
				MovieQuestion.builder()
						.question(MovieQuestionType.TRANS_WRITER)
						.answer(BooleanAnswer.NO)
						.movie(movie)
						.details("hi hello hurray!")
						.build()
		));

		movieService.save(movie);
//				.characters(List.of(
//						Character.builder()
//								.type()
//								.name()
//								.questions()
//								.build(),
//						Character.builder()
//								.type()
//								.name()
//								.questions()
//								.build()
//				))

	}
}
