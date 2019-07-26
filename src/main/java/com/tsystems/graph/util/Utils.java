package com.tsystems.graph.util;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toCollection;
import static org.springframework.util.CollectionUtils.isEmpty;

public class Utils {

    public static<T extends Collection<R>, R, S> T transformCollection(Collection<S> persons, Supplier<T> collectionFactory, Function<S, R> transform) {
        if (isEmpty(persons)) {
            return collectionFactory.get();
        }
        return persons.stream().map(transform).collect(toCollection(collectionFactory));
    }

}
