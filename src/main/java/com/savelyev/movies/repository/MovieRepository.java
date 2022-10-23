package com.savelyev.movies.repository;

import com.savelyev.movies.model.Genre;
import com.savelyev.movies.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    Page<Movie> findAll(Pageable pageable);

    Page<Movie> findAllByCountry(Pageable pageable, String country);

    Page<Movie> findAllByGenres(Pageable pageable, Genre genre);

    Page<Movie> findAllByCountryAndGenres(Pageable pageable,String country, Genre genre);


}
