package com.savelyev.movies.service;


import com.savelyev.movies.model.Genre;
import com.savelyev.movies.model.Movie;
import com.savelyev.movies.exception.EntityNotFoundException;
import com.savelyev.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    private final String MOVIE_NOT_FOUND_MSG = "Movie not found";

    public Movie findMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(MOVIE_NOT_FOUND_MSG));

    }

    public Page<Movie> findAllMovies(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    public Page<Movie> findAllMoviesByCountryAndGenres(Pageable pageable, String country, Genre genre) {
        return movieRepository.findAllByCountryAndGenres(pageable, country, genre);
    }

    public Page<Movie> findAllMoviesByCountry(Pageable pageable, String country) {
        return movieRepository.findAllByCountry(pageable, country);
    }

    public Page<Movie> findAllByGenres(Pageable pageable, Genre genre) {
        return movieRepository.findAllByGenres(pageable, genre);
    }


    public Page<Movie> findAllMoviesByParams(Pageable pageable, String country, Genre genre) {
        if (country != null && genre != null) {
            return findAllMoviesByCountryAndGenres(pageable, country, genre);
        }
        if (country != null) {
            return findAllMoviesByCountry(pageable, country);
        }
        if (genre != null) {
            return findAllByGenres(pageable, genre);
        }
        return findAllMovies(pageable);
    }


    public void saveMovie(Movie movie){
        movieRepository.save(movie);
    }


}
