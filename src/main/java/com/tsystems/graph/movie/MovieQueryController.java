package com.tsystems.graph.movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static java.lang.String.format;
import static java.util.stream.Collectors.toSet;

@RestController
public class MovieQueryController {

    private final MovieQueryService movieQueryService;

    public MovieQueryController(MovieQueryService movieQueryService) {
        this.movieQueryService = movieQueryService;
    }

    @GetMapping(path = "/movies")
    public Collection<MovieResponse> getAll() {
        return movieQueryService.getAll().map(MovieResponse::of).collect(toSet());
    }

    @GetMapping(path = "/movies/{id}")
    public MovieResponse getById(@PathVariable("id") Long id) {
        return MovieResponse.of(movieQueryService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException(format("There is no movie with the id %s", id))));
    }

}
