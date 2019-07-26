package com.tsystems.graph.database;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.stream.Collectors.joining;
import static java.lang.System.lineSeparator;

import static java.util.Objects.requireNonNull;

@RestController
public class DatabaseInfoQueryController {

    private final DatabaseInfoQueryService databaseInfoQueryService;

    public DatabaseInfoQueryController(DatabaseInfoQueryService databaseInfoQueryService) {
        this.databaseInfoQueryService = requireNonNull(databaseInfoQueryService);
    }

    @GetMapping(path = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getInfo() {
        return databaseInfoQueryService.getInfo().collect(joining(lineSeparator()));
    }

}
