package com.savelyev.movies.repository;

import com.savelyev.movies.model.Movie;
import com.savelyev.movies.model.Review;
import com.savelyev.movies.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Long> {
    @Transactional
    Long deleteByMovieAndUser(Movie movie,User user);

    Review findReviewByUserAndMovie(User user, Movie movie);


}
