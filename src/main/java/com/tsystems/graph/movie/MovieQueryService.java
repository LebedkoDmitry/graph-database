package com.tsystems.graph.movie;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static java.util.stream.StreamSupport.stream;

@Service
public class MovieQueryService {

    private final MovieRepository movieRepository;

    public MovieQueryService(MovieRepository movieRepository) {
        this.movieRepository = requireNonNull(movieRepository);
    }

    @Transactional(readOnly = true)
    public Stream<Movie> getAll() {
        return stream(movieRepository.findAll().spliterator(), false);
    }

    @Transactional(readOnly = true)
    public Optional<Movie> getById(Long id) {
        return movieRepository.findById(id);
    }

}
