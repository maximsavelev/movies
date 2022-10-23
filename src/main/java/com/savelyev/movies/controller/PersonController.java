package com.savelyev.movies.controller;

import com.savelyev.movies.dto.PersonDTO;
import com.savelyev.movies.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(tags = "Person")
public class PersonController {
    private final PersonService personService;

    private final ControllerUtils controllerUtils;

    @Operation(summary = "Getting a person by its id")
    @GetMapping("/persons/{id}")
    public PersonDTO findPersonById(@PathVariable Long id) {
        return controllerUtils.mapEntityToDto(personService.findPersonById(id), PersonDTO.class);
    }


}

