package dev.coderkini.tailfin.accounts.domain;

import io.hypersistence.tsid.TSID;

/**
 * Represents a unique identifier for a transaction.
 *
 * @param value     reference to an instance of {@link TSID} that represents the unique identifier for the transaction.
 */
public record TransactionId(TSID value) {

    public TransactionId {
        if (value == null) {
            value = TSID.Factory.getTsid();
        }
    }

    /**
     * Generates a new instance of {@link TransactionId} with a unique identifier.
     *
     * @return A new instance of {@link TransactionId} with a unique identifier.
     */
    public static TransactionId generate() {
        return new TransactionId(null);
    }

    /**
     * Returns a new instance of {@link TransactionId} from the specified string value.
     *
     * @param value     The string value of the unique identifier.
     *
     * @return         A new instance of {@link TransactionId} from the specified string value.
     */
    public static TransactionId from(String value) {
        return new TransactionId(TSID.from(value));
    }
}
