package com.tsystems.graph.database;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

@Service
public class DatabaseInfoQueryService {

    private final DatabaseInfoRepository databaseInfoRepository;

    public DatabaseInfoQueryService(DatabaseInfoRepository databaseInfoRepository) {
        this.databaseInfoRepository = requireNonNull(databaseInfoRepository);
    }

    @Transactional(readOnly = true)
    public Stream<String> getInfo() {
        return databaseInfoRepository.getInfo();
    }

}
