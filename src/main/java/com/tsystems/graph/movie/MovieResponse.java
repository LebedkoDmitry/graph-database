package com.tsystems.graph.movie;

import com.tsystems.graph.person.PersonSimpleResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import static com.tsystems.graph.util.Utils.transformCollection;

@NoArgsConstructor
@Data
public class MovieResponse extends MovieSimpleResponse {

    @EqualsAndHashCode.Exclude
    private Set<PersonSimpleResponse> actors;
    @EqualsAndHashCode.Exclude
    private Set<PersonSimpleResponse> directors;
    @EqualsAndHashCode.Exclude
    private Set<PersonSimpleResponse> producers;
    @EqualsAndHashCode.Exclude
    private Set<PersonSimpleResponse> writers;
    @EqualsAndHashCode.Exclude
    private Set<PersonSimpleResponse> reviewers;

    @Builder(builderMethodName = "movieResponseBuilder")
    public MovieResponse(Long id, String title, String tagline, Integer released, Set<PersonSimpleResponse> actors,
                         Set<PersonSimpleResponse> directors, Set<PersonSimpleResponse> producers, Set<PersonSimpleResponse> writers, Set<PersonSimpleResponse> reviewers) {
        super(id, title, tagline, released);
        this.actors = actors;
        this.directors = directors;
        this.producers = producers;
        this.writers = writers;
        this.reviewers = reviewers;
    }

    public static MovieResponse of(Movie movie) {
        if (movie == null) {
            return null;
        } else {
            return MovieResponse.movieResponseBuilder()
                    .id(movie.getId())
                    .title(movie.getTitle())
                    .tagline(movie.getTagline())
                    .released(movie.getReleased())
                    .actors(transformCollection(movie.getActors(), HashSet::new, PersonSimpleResponse::of))
                    .directors(transformCollection(movie.getDirectors(), HashSet::new, PersonSimpleResponse::of))
                    .producers(transformCollection(movie.getProducers(), HashSet::new, PersonSimpleResponse::of))
                    .writers(transformCollection(movie.getWriters(), HashSet::new, PersonSimpleResponse::of))
                    .reviewers(transformCollection(movie.getReviewers(), HashSet::new, PersonSimpleResponse::of))
                    .build();
        }
    }

}
