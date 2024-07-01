package dev.coderkini.tailfin.commons.repository;

import java.util.Objects;

/**
 * Represents a filter definition with a field, operator and value.
 *
 * @param <T>          the type of the value to filter on
 * @param field        the field to filter on
 * @param operator     the operator to use for the filter
 * @param value        the value to filter on
 */
public record FilterDefinition<T>(String field, FilterOperator operator, T value) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilterDefinition<?> that = (FilterDefinition<?>) o;
        return Objects.equals(field, that.field);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(field);
    }
}
