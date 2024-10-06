package com.ewaterman.genderinfilm.movies;

import com.ewaterman.genderinfilm.common.BooleanAnswer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents a single question pertaining to a movie.
 */
@Entity
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieQuestion {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable=false)
    private Movie movie;

    private MovieQuestionType question;
    private BooleanAnswer answer;

    /**
     * In case the answer needs a longer explanation.
     */
    private String details;

}
