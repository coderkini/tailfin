package dev.coderkini.tailfin.accounts.domain;

import io.hypersistence.tsid.TSID;

/**
 * Represents a unique identifier for an account.
 *
 * @param value reference to an instance of {@link TSID} which represents the unique identifier for the account.
 */
public record AccountId(TSID value) {
    public AccountId {
        if (value == null) {
            value = TSID.Factory.getTsid();
        }
    }

    /**
     * Generate a new AccountId instance with a unique identifier.
     *
     * @return  reference to new instance of {@link AccountId} which represents the unique identifier for the account.
     */
    public static AccountId generate() {
        return new AccountId(TSID.Factory.getTsid());
    }

    /**
     * Create a new AccountId instance from the specified string value.
     *
     * @param value     The string value of the unique identifier.
     *
     * @return  reference to new instance of {@link AccountId} which represents the unique identifier for the account.
     */
    public static AccountId fromString(String value) {
        return new AccountId(TSID.from(value));
    }
}
