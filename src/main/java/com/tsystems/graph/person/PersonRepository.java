package com.tsystems.graph.person;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    @Query("MATCH (p:Person)-[r:DIRECTED]->(m:Movie) RETURN p, r, m")
    Stream<Person> getDirectors();

    @Query("MATCH (p:Person)-[r:PRODUCED]->(m:Movie) RETURN p, m")
    Stream<Person> getProducers();

}
