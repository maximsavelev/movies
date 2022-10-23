package com.savelyev.movies.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "persons")
public class Person extends BaseEntity {
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "middlename")
    private String middleName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "englishname")
    private String englishName;
    @Column(name = "country")
    private String country;
    @Column(name = "birthday")
    private LocalDate birthDay;
    @Column(name = "profilephoto")
    private String profilePhoto;


    @ManyToMany
    @JoinTable(name = "movie_cast",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies;
    @OneToMany
    @JoinTable(name = "amplua",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<PersonRole> personRoles;
}
