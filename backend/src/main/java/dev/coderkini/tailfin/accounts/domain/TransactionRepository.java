package dev.coderkini.tailfin.accounts.domain;

import java.time.LocalDateTime;
import javax.money.MonetaryAmount;

import dev.coderkini.tailfin.commons.repository.PagedResult;
import dev.coderkini.tailfin.commons.repository.QueryConstraints;

/**
 * Represents a repository for transactions.
 *
 * @see Transaction
 * @see TransactionId
 * @see AccountId
 * @see Account
 * @see MonetaryAmount
 * @see PagedResult
 * @see QueryConstraints
 * @see LocalDateTime
 */
public interface TransactionRepository {
    /**
     * Retrieves the transaction with the specified unique identifier from the repository.
     *
     * @param id reference to an instance of {@link TransactionId} that represents the unique identifier for the
     *           transaction to be retrieved.
     * @return reference to an instance of {@link Transaction} that represents the transaction with the specified
     *          unique identifier.
     */
    Transaction findById(TransactionId id);

    /**
     * Retrieves all the transactions from the repository.
     *
     * @param constraints   reference to an instance of {@link QueryConstraints} that represents the constraints to be
     *                      applied to the query.
     *
     * @return reference to an instance of {@link PagedResult} that represents the transactions.
     */
    PagedResult<Transaction> findAll(QueryConstraints<Transaction> constraints);

    /**
     * Retrieves the transactions for the specified account from the repository.
     *
     * @param accountId    reference to an instance of {@link AccountId} that represents the unique identifier for the
     *                     account.
     * @param constraints  reference to an instance of {@link QueryConstraints} that represents the constraints to be
     *                     applied to the query.
     *
     * @return reference to an instance of {@link PagedResult} that represents the transactions for the specified account.
     */
    PagedResult<Transaction> findByAccountId(AccountId accountId, QueryConstraints<Transaction> constraints);

    /**
     * Retrieves the transactions for the specified account within the specified date range from the repository.
     *
     * @param accountId     reference to an instance of {@link AccountId} that represents the unique identifier for the
     *                      account.
     * @param startDate     reference to an instance of {@link LocalDateTime} that represents the start date for the
     *                      date range.
     * @param endDate       reference to an instance of {@link LocalDateTime} that represents the end date for the
     *                      date range.
     * @param constraints   reference to an instance of {@link QueryConstraints} that represents the constraints to be
     *                      applied to the query.
     *
     * @return reference to an instance of {@link PagedResult} that represents the transactions for the specified
     *          account
     */
    PagedResult<Transaction> findByAccountAndDateRange(AccountId accountId,
                                                       LocalDateTime startDate,
                                                       LocalDateTime endDate,
                                                       QueryConstraints<Transaction> constraints);

    /**
     * Saves the specified transaction to the repository.
     *
     * @param transaction reference to an instance of {@link Transaction} that represents the transaction to be saved.
     */
    void save(Transaction transaction);

    /**
     * Retrieves the balance for the specified account from the repository.
     *
     * @param accountId reference to an instance of {@link AccountId} that represents the unique identifier for the account.
     *
     * @return reference to an instance of {@link MonetaryAmount} that represents the balance for the specified account.
     */
    MonetaryAmount getAccountBalance(AccountId accountId);
}
