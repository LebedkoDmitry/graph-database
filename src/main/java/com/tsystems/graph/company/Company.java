package com.tsystems.graph.company;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.id.UuidStrategy;

@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "companyBuilder")
@Data
@NodeEntity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonTypeName("Company")
public class Company {

    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    @Property(name = "id")
    private String id;

    @Property(name = "name")
    private String name;

}
