package com.tsystems.graph.person;

import com.tsystems.graph.movie.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toList;

@DataNeo4jTest
class PersonRepositoryTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void getDirectors() {
        personRepository.saveAll(Arrays.asList(
                Person.builder()
                        .name("John Doe")
                        .born(1960)
                        .directedMovies(new HashSet<>(Arrays.asList(
                                Movie.builder()
                                        .title("The first film")
                                        .tagline("This is the first film")
                                        .released(2001)
                                        .build(),
                                Movie.builder()
                                        .title("The second film")
                                        .tagline("This is the second film")
                                        .released(2002)
                                        .build()
                        )))
                        .build(),
                Person.builder()
                .name("Jack Doe")
                .born(1961)
                .build()
        ));
        final List<Person> directors = personRepository.getDirectors().collect(toList());
        assertThat(directors).hasSize(1);
        final Person director = directors.get(0);
        assertThat(director.getId()).isNotNull();
        assertThat(director.getName()).isEqualTo("John Doe");
        assertThat(director.getBorn()).isEqualTo(1960);
        assertThat(director.getDirectedMovies()).hasSize(2);
        final Map<String, Movie> movies = director.getDirectedMovies().stream().collect(toMap(Movie::getTitle, identity()));
        assertThat(movies.get("The first film")).isNotNull();
        assertThat(movies.get("The first film").getId()).isNotNull();
        assertThat(movies.get("The first film").getTagline()).isEqualTo("This is the first film");
        assertThat(movies.get("The first film").getReleased()).isEqualTo(2001);
        assertThat(movies.get("The second film")).isNotNull();
        assertThat(movies.get("The second film").getId()).isNotNull();
        assertThat(movies.get("The second film").getTagline()).isEqualTo("This is the second film");
        assertThat(movies.get("The second film").getReleased()).isEqualTo(2002);
    }

}
