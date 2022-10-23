package com.savelyev.movies.dto;

import com.savelyev.movies.model.Movie;
import com.savelyev.movies.model.PersonRole;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PersonDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private String englishName;
    private String country;
    private LocalDate birthDay;
    private String profilePhoto;
    private List<Movie> movies;
    private List<PersonRole> personRoles;

}
