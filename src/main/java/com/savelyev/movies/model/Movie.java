package com.savelyev.movies.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "movies")
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class Movie extends BaseEntity {
    private String title;
    @Column(name = "originaltitle")
    private String originalTitle;
    @Column(name = "productionyear")
    private int productionYear;
    private String country;
    private String time;
    private String poster;
    private String description;

    @ManyToMany
    @JoinTable(name = "movie_cast",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> cast = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;
    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();
}