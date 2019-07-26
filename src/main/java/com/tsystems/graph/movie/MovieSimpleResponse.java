package com.tsystems.graph.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieSimpleResponse {

    private Long id;
    private String title;
    private String tagline;
    private Integer released;

    public static MovieSimpleResponse of(Movie movie) {
        if (movie == null) {
            return null;
        } else {
            return MovieResponse.builder()
                    .id(movie.getId())
                    .title(movie.getTitle())
                    .tagline(movie.getTagline())
                    .released(movie.getReleased())
                    .build();
        }
    }

}
