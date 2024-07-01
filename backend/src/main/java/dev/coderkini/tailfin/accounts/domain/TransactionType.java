package dev.coderkini.tailfin.accounts.domain;

/**
 * Represents the type of transaction.
 */
public enum TransactionType {
    /**
     * Represents a deposit transaction.
     */
    DEPOSIT("cr"),

    /**
     * Represents a withdrawal transaction.
     */
    WITHDRAWAL("dr");

    private final String value;

    /**
     * Create a new TransactionType instance with the specified value.
     *
     * @param value The value of the transaction type.
     */
    TransactionType(String value) {
        this.value = value;
    }

    /**
     * Get the value of the transaction type.
     *
     * @return  The value of the transaction type.
     */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
