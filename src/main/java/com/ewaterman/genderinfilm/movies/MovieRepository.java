package com.ewaterman.genderinfilm.movies;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    Optional<Movie> findByTmdbId(String tmdbId);
}