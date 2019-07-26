package com.tsystems.graph.person;

import com.tsystems.graph.movie.MovieSimpleResponse;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import static com.tsystems.graph.util.Utils.transformCollection;

@NoArgsConstructor
@Data
public class PersonResponse extends PersonSimpleResponse {

    private Set<MovieSimpleResponse> actedMovies;
    private Set<MovieSimpleResponse> directedMovies;
    private Set<MovieSimpleResponse> producedMovies;
    private Set<MovieSimpleResponse> wroteMovies;
    private Set<MovieSimpleResponse> reviewedMovies;

    @Builder(builderMethodName = "personResponseBuilder")
    public PersonResponse(Long id, String name, Integer born, Set<MovieSimpleResponse> actedMovies,
                          Set<MovieSimpleResponse> directedMovies, Set<MovieSimpleResponse> producedMovies, Set<MovieSimpleResponse> wroteMovies, Set<MovieSimpleResponse> reviewedMovies) {
        super(id, name, born);
        this.actedMovies = actedMovies;
        this.directedMovies = directedMovies;
        this.producedMovies = producedMovies;
        this.wroteMovies = wroteMovies;
        this.reviewedMovies = reviewedMovies;
    }

    public static PersonResponse of(Person person) {
        if (person == null) {
            return null;
        } else {
            return PersonResponse.personResponseBuilder()
                    .id(person.getId())
                    .name(person.getName())
                    .born(person.getBorn())
                    .actedMovies(transformCollection(person.getActedMovies(), HashSet::new, MovieSimpleResponse::of))
                    .directedMovies(transformCollection(person.getDirectedMovies(), HashSet::new, MovieSimpleResponse::of))
                    .producedMovies(transformCollection(person.getProducedMovies(), HashSet::new, MovieSimpleResponse::of))
                    .wroteMovies(transformCollection(person.getWroteMovies(), HashSet::new, MovieSimpleResponse::of))
                    .reviewedMovies(transformCollection(person.getReviewedMovies(), HashSet::new, MovieSimpleResponse::of))
                    .build();
        }
    }

}
