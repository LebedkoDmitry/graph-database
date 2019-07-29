package com.tsystems.graph.movie;

import com.tsystems.graph.person.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
    private Set<Person> actors;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Relationship(type = "DIRECTED", direction = Relationship.INCOMING)
    private Set<Person> directors;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Relationship(type = "PRODUCED", direction = Relationship.INCOMING)
    private Set<Person> producers;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Relationship(type = "WROTE", direction = Relationship.INCOMING)
    private Set<Person> writers;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Relationship(type = "REVIEWED", direction = Relationship.INCOMING)
    private Set<Person> reviewers;

}
