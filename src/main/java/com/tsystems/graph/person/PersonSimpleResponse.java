package com.tsystems.graph.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonSimpleResponse {

    private Long id;
    private String name;
    private Integer born;

    public static PersonSimpleResponse of(Person person) {
        if (person == null) {
            return null;
        } else {
            return PersonResponse.builder()
                    .id(person.getId())
                    .name(person.getName())
                    .born(person.getBorn())
                    .build();
        }
    }

}
