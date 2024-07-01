package dev.coderkini.tailfin.accounts.domain;

import io.hypersistence.tsid.TSID;

/**
 * Represents a unique identifier for a bank.
 *
 * @param value The unique identifier for the bank.
 */
public record BankId(TSID value) {
    /**
     * Create a new BankId instance with the specified value.
     *
     * @param value The unique identifier for the bank.
     */
    public BankId {
        if (value == null) {
            value = TSID.Factory.getTsid();
        }
    }

    /**
     * Generate a new BankId instance with a unique identifier.
     *
     * @return A new BankId instance.
     */
    public static BankId generate() {
        return new BankId(null);
    }

    /**
     * Create a new BankId instance from the specified string value.
     *
     * @param value     The string value of the unique identifier.
     *
     * @return A new BankId instance.
     */
    public static BankId fromString(String value) {
        return new BankId(TSID.from(value));
    }
}
