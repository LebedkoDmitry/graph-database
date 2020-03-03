package com.tsystems.graph.person;


import com.tsystems.graph.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode
@NodeEntity
public class Person {

    private Long id;
    private String name;
    private Integer born;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Relationship(type = "ACTED_IN")
    private Set<Movie> actedMovies;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Relationship(type = "DIRECTED")
    private Set<Movie> directedMovies;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Relationship(type = "PRODUCED")
    private Set<Movie> producedMovies;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Relationship(type = "WROTE")
    private Set<Movie> wroteMovies;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Relationship(type = "REVIEWED")
    private Set<Movie> reviewedMovies;
}
