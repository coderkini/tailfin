package dev.coderkini.tailfin.accounts.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.money.MonetaryAmount;

/**
 * Represents a monetary transaction between two accounts.
 *
 * @see TransactionId
 * @see TransactionType
 * @see AccountId
 * @see MonetaryAmount
 * @see Account
 */
public class Transaction {

    private final TransactionId id;
    private final TransactionType type;
    private final AccountId sourceAccountId;
    private final AccountId targetAccountId;
    private final MonetaryAmount amount;
    private final LocalDateTime createdAt;

    /**
     * Create a new instance of {@link Transaction} with the specified unique identifier, type, source account, target
     * account, amount, and creation date.
     *
     * @param id                    reference to an instance of {@link TransactionId} that represents the unique
     * @param type                  reference to an instance of {@link TransactionType} that represents the type of the
     * @param sourceAccountId       reference to an instance of {@link AccountId} that represents the unique identifier
     *                              for the source account.
     * @param targetAccountId       reference to an instance of {@link AccountId} that represents the unique identifier
     *                              for the target account.
     * @param amount                reference to an instance of {@link MonetaryAmount} that represents the amount of
     *                              the transaction.
     * @param createdAt             reference to an instance of {@link LocalDateTime} that represents the date and time
     *                              when the transaction was created.
     */
    public Transaction(TransactionId id,
                       TransactionType type,
                       AccountId sourceAccountId,
                       AccountId targetAccountId,
                       MonetaryAmount amount,
                       LocalDateTime createdAt) {
        this.id = id;
        this.type = type;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    /**
     * Returns the unique identifier for the transaction.
     *
     * @return  reference to an instance of {@link TransactionId} that represents the unique identifier for the
     *          transaction.
     */
    public TransactionId getId() {
        return id;
    }

    /**
     * Returns the type of the transaction.
     *
     * @return reference to an instance of {@link TransactionType} that represents the type of the transaction.
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * Returns the unique identifier for the source account.
     *
     * @return reference to an instance of {@link AccountId} that represents the unique identifier for the source
     */
    public AccountId getSourceAccountId() {
        return sourceAccountId;
    }

    /**
     * Returns the unique identifier for the target account.
     *
     * @return reference to an instance of {@link AccountId} that represents the unique identifier for the target
     */
    public AccountId getTargetAccountId() {
        return targetAccountId;
    }

    /**
     * Returns the amount of the transaction.
     *
     * @return reference to an instance of {@link MonetaryAmount} that represents the amount of the transaction.
     */
    public MonetaryAmount getAmount() {
        return amount;
    }

    /**
     * Returns the date and time when the transaction was created.
     *
     * @return reference to an instance of {@link LocalDateTime} that represents the date and time when the transaction
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type=" + type +
                ", sourceAccountId=" + sourceAccountId +
                ", targetAccountId=" + targetAccountId +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                '}';
    }
}
