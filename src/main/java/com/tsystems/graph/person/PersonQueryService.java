package com.tsystems.graph.person;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

import static java.util.stream.StreamSupport.stream;

@Service
public class PersonQueryService {

    private final PersonRepository personRepository;

    public PersonQueryService(PersonRepository personRepository) {
        this.personRepository = requireNonNull(personRepository);
    }

    @Transactional(readOnly = true)
    public Stream<Person> getAll() {
        return stream(personRepository.findAll().spliterator(), false);
    }

    @Transactional(readOnly = true)
    public Optional<Person> getById(Long id) {
        return personRepository.findById(id);
    }

}
