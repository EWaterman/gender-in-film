package com.ewaterman.genderinfilm.movies;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.ewaterman.genderinfilm.characters.Character;

@Entity
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Character> characters;

    @OneToMany(mappedBy = "movie_question", cascade = CascadeType.ALL)
    private List<MovieQuestion> questions;

    /**
     * Maps movies to their metadata in The Movie Database.
     */
    private String tmdbId;

}
