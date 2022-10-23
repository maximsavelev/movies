package com.savelyev.movies.dto;

import com.savelyev.movies.model.Review;
import com.savelyev.movies.model.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class UserDTO {
    private String email;
    private String username;
    private String password;
    private List<Review> reviews = new ArrayList<>();
    private Collection<Role> roles;
}
