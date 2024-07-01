package dev.coderkini.tailfin.accounts.domain;

import dev.coderkini.tailfin.commons.repository.PagedResult;
import dev.coderkini.tailfin.commons.repository.QueryConstraints;

/**
 * Repository for Account entities.
 *
 * @see Account
 * @see AccountId
 * @see QueryConstraints
 * @see PagedResult
 */
public interface AccountRepository {
    /**
     * Find an account by its ID.
     *
     * @param id reference to the {@link AccountId} that represents the ID of the account
     *
     * @return reference to the {@link Account} with the given id, or null if no such account exists
     */
    Account findById(AccountId id);

    /**
     * Find an account by its account number.
     *
     * @param accountNumber the account number
     *
     * @return reference to the {@link Account} with the given account number, or null if no such account exists
     */
    Account findByAccountNumber(String accountNumber);

    /**
     * Find accounts by the specified bank ID.
     *
     * @param bankId            reference to the {@link BankId} to search by
     * @param constraints       reference to the {@link QueryConstraints} to apply to the query
     *
     * @return reference to a {@link PagedResult} containing the accounts that match the specified bank ID
     */
    PagedResult<Account> findAccountsByBank(BankId bankId, QueryConstraints<Account> constraints);

    /**
     * Find accounts by the specified customer ID.
     *
     * @param account   the account to save
     *
     * @return the saved account
     */
    Account save(Account account);

    /**
     * Delete the specified account.
     *
     * @param account   reference to the {@link Account} to delete
     */
    void delete(Account account);

    /**
     * Update the specified account.
     *
     * @param account  reference to the {@link Account} to update
     */
    void update(Account account);
}
