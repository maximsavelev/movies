package com.savelyev.movies.service;

import com.savelyev.movies.exception.EntityNotFoundException;
import com.savelyev.movies.model.Movie;
import com.savelyev.movies.model.Review;
import com.savelyev.movies.model.User;
import com.savelyev.movies.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;


    public void findReviewById(Long id) {
        reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Review findReviewByUserAndMovie(User user, Movie movie) {
        return reviewRepository.findReviewByUserAndMovie(user, movie);
    }

    public void saveReview(String text, User user, Movie movie) {
        Review review = new Review(text, user, movie);
        reviewRepository.save(review);
    }

    public Long deleteReviewByMovieAndUser(Movie movie, User user) {
        return reviewRepository.deleteByMovieAndUser(movie, user);
    }


}
