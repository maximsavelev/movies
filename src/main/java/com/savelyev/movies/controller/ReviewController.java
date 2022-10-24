package com.savelyev.movies.controller;

import com.savelyev.movies.model.Movie;
import com.savelyev.movies.model.Review;
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
import java.security.Principal;

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
    public ResponseEntity<String> addReview(@RequestParam Long movieId, @RequestParam String text,
                                            Principal principal) throws URISyntaxException {
        Movie movieById = movieService.findMovieById(movieId);
        User user = userService.findUserByUsername(principal.getName());
        Review review = reviewService.saveReview(text, user, movieById);
        final String message = "Review: %s added to movie with id %d by user %s";
        return  ResponseEntity.created(new URI("/addReview")).body(String.format(message,review.getReview(),movieId, user.getUsername()));
    }

    @Operation(summary = "Deleting a user's review from movie by its id")
    @DeleteMapping("/deleteReview")
    public ResponseEntity removeReview(@RequestParam Long movieId) {
        User userById = userService.findUserById(2L);
        Movie movieById = movieService.findMovieById(movieId);
        Long isDeleted = reviewService.deleteReviewByMovieAndUser(movieById, userById);
        return isDeleted > 0 ? ResponseEntity.ok().build() : ResponseEntity.noContent().build();
    }

    @GetMapping("/test")
    public ResponseEntity<User> test(Principal principal){
        User userByUsername = userService.findUserByUsername(principal.getName());
        System.out.println(userByUsername);
        return ResponseEntity.ok(userByUsername);
    }


}
