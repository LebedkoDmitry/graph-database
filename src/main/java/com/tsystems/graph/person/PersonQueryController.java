package com.tsystems.graph.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toSet;
import static java.lang.String.format;

@RestController
public class PersonQueryController {

    private final PersonQueryService personQueryService;

    public PersonQueryController(PersonQueryService personQueryService) {
        this.personQueryService = requireNonNull(personQueryService);
    }

    @GetMapping(path = "/person")
    public Collection<PersonResponse> getAll() {
        return personQueryService.getAll().map(PersonResponse::of).collect(toSet());
    }

    @GetMapping(path = "/person/{id}")
    public PersonResponse getById(@PathVariable(name = "id") Long id) {
        return PersonResponse.of(personQueryService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException(format("There is no person with the id %s", id))));
    }

    @GetMapping(path = "/person/producers")
    public Collection<PersonResponse> getProducers() {
        return personQueryService.getProducers().map(PersonResponse::of).collect(toSet());
    }

    @GetMapping(path = "/person/directors")
    public Collection<PersonResponse> getDirectors() {
        return personQueryService.getDirectors().map(PersonResponse::of).collect(toSet());
    }

}
