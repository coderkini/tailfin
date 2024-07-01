package dev.coderkini.tailfin.commons.repository;

import java.util.Map;
import java.util.Set;

/**
 * Represents constraints for querying items from a repository.
 *
 * @param <T>   The type of items to query.
 *
 * @see SortDirection
 * @see FilterDefinition
 * @see FilterOperator
 */
public class QueryConstraints<T> {
    /**
     * The default limit for the number of items to return.
     */
    public final static int DEFAULT_LIMIT = 10;

    /**
     * The default offset from the beginning of the result set.
     */
    public final static long DEFAULT_OFFSET = 0;

    private final Map<String, SortDirection> sorting;
    private final Set<FilterDefinition<?>> filters;

    private int limit = DEFAULT_LIMIT;
    private long offset = DEFAULT_OFFSET;

    /**
     * Creates a new instance of {@link QueryConstraints} with default limit and offset and no filters or sorting.
     *
     * @see #DEFAULT_LIMIT
     * @see #DEFAULT_OFFSET
     */
    QueryConstraints() {
        this(Map.of(), Set.of());
    }

    /**
     * Creates a new instance of {@link QueryConstraints} with the specified sorting and filters and default
     * limit and offset.
     *
     * @param sorting   The sorting constraints for the query.
     * @param filters   The filters to apply to the query.
     *
     * @see #DEFAULT_LIMIT
     * @see #DEFAULT_OFFSET
     */
    public QueryConstraints(Map<String, SortDirection> sorting, Set<FilterDefinition<?>> filters) {
        this.sorting = sorting;
        this.filters = filters;
    }

    /**
     * Creates a new instance of {@link QueryConstraints} with the sorting, filters copied from specified constraints
     * and specified limit, and offset.
     *
     * @param constraints   The constraints to copy.
     * @param limit         The maximum number of items to return.
     * @param offset        The offset from the beginning of the result set.
     */
    QueryConstraints(QueryConstraints<T> constraints, int limit, long offset) {
        this.sorting = constraints.sorting;
        this.limit = limit;
        this.offset = offset;
        this.filters = constraints.filters;
    }

    /**
     * Creates a new instance of {@link QueryConstraints} with default limit and offset and no filters or sorting.
     *
     * @return A new instance of {@link QueryConstraints}.
     *
     * @param <T>   The type of items to query.
     */
    public static <T> QueryConstraints<T> of()  {
        return new QueryConstraints<>();
    }

    /**
     * Creates a new instance of {@link QueryConstraints} with the specified sorting and filters and default
     *
     * @param field         The field to sort by.
     * @param direction     The direction to sort the field.
     * @return              The updated {@link QueryConstraints} instance.
     */
    public QueryConstraints<T> sortBy(String field, SortDirection direction) {
        sorting.put(field, direction);
        return this;
    }

    /**
     * Sets the limit and offset for the query.
     *
     * @param limit     The maximum number of items to return.
     * @param offset    The offset from the beginning of the result set.
     *
     * @return         The updated {@link QueryConstraints} instance.
     */
    public QueryConstraints<T> page(int limit, long offset) {
        this.limit = limit;
        this.offset = offset;
        return this;
    }

    /**
     * Adds a filter to the query on the specified field with the specified operator and value.
     *
     * @param <VT>          The type of the value to filter by.
     * @param field         The field to filter by.
     * @param operator      The {@link FilterOperator} to use for the filter.
     * @param value         The value to filter by.
     *
     * @see FilterOperator
     *
     * @return  The updated {@link QueryConstraints} instance.
     */
    public <VT> QueryConstraints<T> filter(String field, FilterOperator operator, VT value) {
        filters.add(new FilterDefinition<>(field, operator, value));
        return this;
    }

    /**
     * Returns the sorting constraints for the query.
     *
     * @return  The sorting constraints for the query.
     */
    public Map<String, SortDirection> getSorting() {
        return sorting;
    }

    /**
     * Returns the maximum number of items to return.
     *
     * @return  The maximum number of items to return.
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Returns the offset from the beginning of the result set.
     *
     * @return  The offset from the beginning of the result set.
     */
    public long getOffset() {
        return offset;
    }

    /**
     * Returns the filters to apply to the query.
     *
     * @return      The filters to apply to the query.
     */
    public Set<? super FilterDefinition<?>> getFilters() {
        return filters;
    }

    /**
     * Returns a new instance of {@link QueryConstraints} with the limit and offset incremented by one.
     *
     * @return A new instance of {@link QueryConstraints}.
     */
    public QueryConstraints<T> nextPage() {
        return new QueryConstraints<>(this, limit, offset + 1L);
    }

    /**
     * Returns a new instance of {@link QueryConstraints} with the limit and offset decremented by one.
     *
     * @return  A new instance of {@link QueryConstraints}.
     */
    public QueryConstraints<T> previousPage() {
        return new QueryConstraints<>(this, limit, offset - 1L);
    }

    /**
     * Returns a new instance of {@link QueryConstraints} with the limit and offset set to the default values.
     *
     * @return  A new instance of {@link QueryConstraints}.
     */
    public QueryConstraints<T> firstPage() {
        return new QueryConstraints<>(this, limit, DEFAULT_OFFSET);
    }

    /**
     * Returns a new instance of {@link QueryConstraints} with the specified page number and default limit.
     *
     * @param pageNumber    The page number to return.
     * @return            A new instance of {@link QueryConstraints}.
     */
    public QueryConstraints<T> toPage(long pageNumber) {
        return new QueryConstraints<>(this, limit, pageNumber);
    }
}
