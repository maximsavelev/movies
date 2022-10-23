package com.savelyev.movies.service;

import com.savelyev.movies.model.User;
import com.savelyev.movies.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserService  {

   private final UserRepository userRepository;
  public User findUserById(Long id) {
      return(userRepository.findById(id).orElseThrow(EntityNotFoundException::new));
  }
}
