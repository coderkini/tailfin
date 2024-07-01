package dev.coderkini.tailfin.commons.repository;

import java.util.List;
import java.util.stream.Stream;

/**
 * Represents a paged result of items with the specified constraints and total.
 *
 * @param <T>               The type of items in the result.
 * @param items             The items in the current page.
 * @param constraints       The constraints used to fetch the items.
 * @param totalItems        The total number of items that match the constraints.
 */
public record PagedResult<T>(Stream<T> items, QueryConstraints<T> constraints, long totalItems) {
    /**
     * Returns an instance of {@link QueryConstraints} that can be used to fetch the next page of items.
     *
     * @return  an instance of {@link QueryConstraints} that can be used to fetch the next page of items.
     */
    public QueryConstraints<T> nextPage() {
        return constraints.nextPage();
    }

    /**
     * Returns an instance of {@link QueryConstraints} that can be used to fetch the previous page of items.
     *
     * @return an instance of {@link QueryConstraints} that can be used to fetch the previous page of items.
     */
    public QueryConstraints<T> previousPage() {
        return constraints.previousPage();
    }

    /**
     * Returns an instance of {@link QueryConstraints} that can be used to fetch the first page of items.
     *
     * @return an instance of {@link QueryConstraints} that can be used to fetch the first page of items.
     */
    public QueryConstraints<T> firstPage() {
        return constraints.firstPage();
    }

    /**
     * <p>Returns an instance of {@link QueryConstraints} that can be used to fetch the last page of items.</p>
     *
     * <p>The last page is calculated by dividing the total number of items matching the constraints with the maximum
     * number of items limit on the constraints.</p>
     *
     *
     * @return an instance of {@link QueryConstraints} that can be used to fetch the last page of items.
     */
    public QueryConstraints<T> lastPage() {
        long lastPage = totalItems / constraints.getLimit();
        return constraints.toPage(lastPage);
    }

    /**
     * Returns an instance of {@link QueryConstraints} that can be used to fetch the specified page of items.
     *
     * @param pageNumber   The page number to fetch.
     *
     * @return an instance of {@link QueryConstraints} that can be used to fetch the specified page of items.
     */
    public QueryConstraints<T> toPage(long pageNumber) {
        return constraints.toPage(pageNumber);
    }
}
