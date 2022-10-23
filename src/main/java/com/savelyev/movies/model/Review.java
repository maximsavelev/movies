package com.savelyev.movies.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "review")
@NoArgsConstructor
public class Review extends BaseEntity{
    private String review;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="movie_id")
    private Movie movie;

    public Review(String review, User user, Movie movie) {
        this.review = review;
        this.user = user;
        this.movie = movie;
    }
}