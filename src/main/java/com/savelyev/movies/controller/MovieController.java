package com.savelyev.movies.controller;

import com.savelyev.movies.dto.MovieDTO;
import com.savelyev.movies.model.Genre;
import com.savelyev.movies.model.Movie;
import com.savelyev.movies.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@Api(tags = "Movies")
public class MovieController {

    private final MovieService movieService;
    private final ControllerUtils controllerUtils;

    @Operation(summary = "Getting a movie by its id")
    @GetMapping("/movies/{id}")
    public MovieDTO findMovieById(@PathVariable Long id) {
        return controllerUtils.mapEntityToDto(movieService.findMovieById(id), MovieDTO.class);
    }


    @Operation(summary = "Getting a list of movies(includes filtering with params like country and genre)")
    @GetMapping("/movies")
    public Page<MovieDTO> findAllMoviesByParams(Pageable pageable, @RequestParam(required = false) String country,
                                                @RequestParam(required = false) Genre genre) {
        return controllerUtils.mapEntityPageIntoDtoPage(movieService.findAllMoviesByParams(pageable, country, genre), MovieDTO.class);
    }

    @Operation(summary = "Adding a new movie")
    @PostMapping("/addMovie")
    public void addMovie(@RequestBody @Valid MovieDTO movieDTO) {
        movieService.saveMovie(controllerUtils.mapEntityToDto(movieDTO, Movie.class));
    }

}
