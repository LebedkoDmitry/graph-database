package com.tsystems.graph.person;


import com.tsystems.graph.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode
public class Person {

    private Long id;
    private String name;
    private Integer born;
    @EqualsAndHashCode.Exclude
    @Relationship(type = "ACTED_IN")
    private Set<Movie> actedMovies;
    @EqualsAndHashCode.Exclude
    @Relationship(type = "DIRECTED")
    private Set<Movie> directedMovies;
    @EqualsAndHashCode.Exclude
    @Relationship(type = "PRODUCED")
    private Set<Movie> producedMovies;
    @EqualsAndHashCode.Exclude
    @Relationship(type = "WROTE")
    private Set<Movie> wroteMovies;
    @EqualsAndHashCode.Exclude
    @Relationship(type = "REVIEWED")
    private Set<Movie> reviewedMovies;
}
