package com.tsystems.graph.company;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends Neo4jRepository<Company, String> {
}
