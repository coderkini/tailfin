package dev.coderkini.tailfin.accounts.domain;

/**
 * AccountType represents different types of accounts.
 */
public enum AccountType {
    /**
     * Represents a savings account.
     */
    SAVINGS("savings"),

    /**
     * Represents a current account.
     */
    CURRENT("current"),

    /**
     * Represents a cash account.
     */
    CASH("cash"),

    /**
     * Represents a credit card account.
     */
    CREDIT_CARD("credit-card"),

    /**
     * Represents a debit card account.
     */
    DEBIT_CARD("debit-card"),

    /**
     * Represents a fixed deposit account.
     */
    FIXED_DEPOSIT("fixed deposit"),

    /**
     * Represents a loan account.
     */
    LOAN("loan");

    private final String name;

    /**
     * Create a new AccountType instance with the specified name.
     *
     * @param name  The name of the account type.
     */
    AccountType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
