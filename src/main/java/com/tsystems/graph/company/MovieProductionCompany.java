package com.tsystems.graph.company;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Property;

@NoArgsConstructor
@Data
//@JsonTypeName("MovieProductionCompany")
public class MovieProductionCompany extends Company {

    @Property(name = "description")
    private String description;

    @Builder
    public MovieProductionCompany(String id, String name, String description) {
        super(id, name);
        this.description = description;
    }
}
