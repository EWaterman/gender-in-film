package com.ewaterman.genderinfilm.movies;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
    @Column(name="id", nullable=false)
    private Long id;

    @OneToMany(mappedBy="movie", cascade=CascadeType.ALL)
    private List<Character> characters;

    @OneToMany(mappedBy="movie", cascade=CascadeType.ALL)
    private List<MovieQuestion> questions;

    /**
     * Maps movies to their metadata in The Movie Database.
     */
    @Column(name="tmdb_id", nullable=false)
    private String tmdbId;

}
