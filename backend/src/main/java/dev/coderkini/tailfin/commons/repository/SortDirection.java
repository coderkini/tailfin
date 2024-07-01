package dev.coderkini.tailfin.commons.repository;

/**
 * Enum representing the sort direction in a query.
 *
 * @see QueryConstraints
 */
public enum SortDirection {
    /**
     * The default sort direction.
     */
    DEFAULT(""),

    /**
     * Sort in ascending order.
     */
    ASCENDING("asc"),

    /**
     * Sort in descending order.
     */
    DESCENDING("desc");

    private final String value;

    /**
     * Creates a new instance of {@link SortDirection} with the specified value.
     *
     * @param value The value of the sort direction.
     */
    SortDirection(String value) {
        this.value = value;
    }

    /**
     * Returns the value of the sort direction.
     *
     * @return  The value of the sort direction.
     */
    public String getValue() {
        return value;
    }

    /**
     * Returns the {@link SortDirection} instance for the specified value.
     *
     * @param value The value of the sort direction.
     *
     * @return  The {@link SortDirection} instance for the specified value.
     *
     * @throws IllegalArgumentException If the specified value is not a valid sort direction.
     */
    public static SortDirection of(String value) {
        for (SortDirection direction : SortDirection.values()) {
            if (direction.value.equals(value)) {
                return direction;
            }
        }
        return DEFAULT;
    }

    @Override
    public String toString() {
        return value;
    }
}
