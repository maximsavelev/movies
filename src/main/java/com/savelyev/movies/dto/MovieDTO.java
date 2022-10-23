package com.savelyev.movies.dto;

import com.savelyev.movies.model.Genre;
import com.savelyev.movies.model.Person;
import com.savelyev.movies.model.Review;
import lombok.Data;

import java.util.List;
@Data
public class MovieDTO {
    private String title;
    private String originalTitle;
    private int productionYear;
    private String country;
    private String time;
    private String poster;
    private String description;
    private List<Person> cast;
    private List<Genre> genres;
    private List<Review> reviews;
}
