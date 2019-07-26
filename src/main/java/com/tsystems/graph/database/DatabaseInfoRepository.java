package com.tsystems.graph.database;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static org.springframework.data.neo4j.transaction.SessionFactoryUtils.getSession;
import static java.util.Collections.emptyMap;
import static java.util.stream.StreamSupport.stream;

@Repository
public class DatabaseInfoRepository {

    private final SessionFactory sessionFactory;

    public DatabaseInfoRepository(SessionFactory sessionFactory) {
        this.sessionFactory = requireNonNull(sessionFactory);
    }

    public Stream<String> getInfo() {
        final Session session = getSession(sessionFactory);
        return stream(session.query(String.class, "CALL dbms.procedures() YIELD name", emptyMap()).spliterator(), false);
    }

}
