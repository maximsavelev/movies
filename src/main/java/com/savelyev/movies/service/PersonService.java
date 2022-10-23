package com.savelyev.movies.service;

import com.savelyev.movies.exception.EntityNotFoundException;
import com.savelyev.movies.model.Person;
import com.savelyev.movies.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    public Person findPersonById(Long id) {
        return (personRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }
}
