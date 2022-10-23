package com.savelyev.movies.controller;

import com.savelyev.movies.model.Movie;
import com.savelyev.movies.model.User;
import com.savelyev.movies.service.MovieService;
import com.savelyev.movies.service.ReviewService;
import com.savelyev.movies.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(tags = "Review")
public class ReviewController {

    private final MovieService movieService;
    private final UserService userService;
    private final ReviewService reviewService;

    @Operation(summary = "Adding a review from users to movie by its id")
    @PostMapping("/addReview")
    public ResponseEntity addReview(@RequestParam Long movieId, @RequestParam String text) throws URISyntaxException {
        //TODO: find user by header
        Long userId = 2L;
        Movie movieById = null;
        try {
            movieById = movieService.findMovieById(movieId);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
        User user = userService.findUserById(2L);
        reviewService.saveReview(text, user, movieById);
        return  ResponseEntity.created(new URI("/addReview")).build();
    }

    @Operation(summary = "Deleting a user's review from movie by its id")
    @DeleteMapping("/deleteReview")
    public ResponseEntity removeReview(@RequestParam Long movieId) {
        User userById = userService.findUserById(2L);
        Movie movieById = movieService.findMovieById(movieId);
        Long isDeleted = reviewService.deleteReviewByMovieAndUser(movieById, userById);
        return isDeleted > 0 ? ResponseEntity.ok().build() : ResponseEntity.noContent().build();
    }


}
