package com.tsystems.graph.movie;

import com.tsystems.graph.person.Person;
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
public class Movie {

    private Long id;
    private String title;
    private String tagline;
    private Integer released;
    @EqualsAndHashCode.Exclude
    @Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
    private Set<Person> actors;
    @EqualsAndHashCode.Exclude
    @Relationship(type = "DIRECTED", direction = Relationship.INCOMING)
    private Set<Person> directors;
    @EqualsAndHashCode.Exclude
    @Relationship(type = "PRODUCED", direction = Relationship.INCOMING)
    private Set<Person> producers;
    @EqualsAndHashCode.Exclude
    @Relationship(type = "WROTE", direction = Relationship.INCOMING)
    private Set<Person> writers;
    @EqualsAndHashCode.Exclude
    @Relationship(type = "REVIEWED", direction = Relationship.INCOMING)
    private Set<Person> reviewers;

}
