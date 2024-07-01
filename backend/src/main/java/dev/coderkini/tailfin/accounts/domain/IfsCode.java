package dev.coderkini.tailfin.accounts.domain;

/**
 * Represents the Indian Financial System Code (IFSC) for a bank branch.
 *
 * @param value The IFSC code value
 */
public record IfsCode(String value) {
    public IfsCode {
        if (value == null) {
            throw new IllegalArgumentException("IFSC cannot be null");
        }
        if (value.length() != 11) {
            throw new IllegalArgumentException("IFSC must be 11 characters long");
        }
    }
}
