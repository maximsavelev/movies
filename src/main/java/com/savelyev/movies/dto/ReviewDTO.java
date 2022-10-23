package com.savelyev.movies.dto;

import lombok.Data;

@Data
public class ReviewDTO {
    private String review;
    private UserDTO user;
    private MovieDTO movie;
}
