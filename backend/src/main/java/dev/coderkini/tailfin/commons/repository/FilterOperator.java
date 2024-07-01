package dev.coderkini.tailfin.commons.repository;

/**
 * Represents the operator used in a query filter.
 *
 * @see FilterDefinition
 * @see QueryConstraints
 */
public enum FilterOperator {
    /**
     * The equals operator.
     */
    EQUALS("="),

    /**
     * The not equals operator.
     */
    NOT_EQUALS("!="),

    /**
     * The greater than operator.
     */
    GREATER_THAN(">"),

    /**
     * The greater than or equals operator.
     */
    GREATER_THAN_OR_EQUALS(">="),

    /**
     * The less than operator.
     */
    LESS_THAN("<"),

    /**
     * The less than or equals operator.
     */
    LESS_THAN_OR_EQUALS("<="),

    /**
     * The like operator.
     */
    LIKE("like"),

    /**
     * The not like operator.
     */
    NOT_LIKE("not like"),

    /**
     * The in operator.
     */
    IN("in"),

    /**
     * The not in operator.
     */
    NOT_IN("not in"),

    /**
     * The is null operator.
     */
    IS_NULL("is null"),

    /**
     * The is not null operator.
     */
    IS_NOT_NULL("is not null");

    private final String value;

    /**
     * Creates a new instance of {@link FilterOperator} with the specified value.
     *
     * @param value The value of the operator.
     */
    FilterOperator(String value) {
        this.value = value;
    }

    /**
     * Returns the value of the operator.
     *
     * @return  The value of the operator.
     */
    public String getValue() {
        return value;
    }

    /**
     * Returns the {@link FilterOperator} with the specified value.
     *
     * @param value The value of the operator.
     *
     * @return     The {@link FilterOperator} with the specified value.
     *
     * @throws IllegalArgumentException If no FilterOperator with the specified value is found.
     */
    public static FilterOperator of(String value) {
        for (FilterOperator operator : FilterOperator.values()) {
            if (operator.value.equalsIgnoreCase(value)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("No FilterOperator with value " + value + " found");
    }

    @Override
    public String toString() {
        return value;
    }
}
