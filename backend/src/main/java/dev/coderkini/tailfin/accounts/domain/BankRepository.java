package dev.coderkini.tailfin.accounts.domain;

import dev.coderkini.tailfin.commons.repository.PagedResult;
import dev.coderkini.tailfin.commons.repository.QueryConstraints;

/**
 * Repository for Bank entities.
 *
 * @see Bank
 * @see BankId
 * @see QueryConstraints
 * @see PagedResult
 */
public interface BankRepository {
    /**
     * Finds all banks by the specified constraints.
     *
     * @param constraints   reference to the {@link QueryConstraints} to apply to the query
     *
     * @return reference to a {@link PagedResult} containing the banks that match the specified constraints
     */
    PagedResult<Bank> findBanks(QueryConstraints<Bank> constraints);

    /**
     * Find a bank by its ID.
     *
     * @param id    reference to the {@link BankId} that represents the ID of the bank
     *
     * @return reference to the {@link Bank} with the given id, or null if no such bank exists
     */
    Bank findById(BankId id);

    /**
     * Find a bank by its IFS code.
     *
     * @param ifsc   the IFS code
     *
     * @return  reference to the {@link Bank} with the given IFS code, or null if no such bank exists
     */
    Bank findByIfsCode(IfsCode ifsc);

    /**
     * Find a bank by its branch name.
     *
     * @param branchName the branch name
     *
     * @return reference to the {@link Bank} with the given branch name, or null if no such bank exists
     */
    Bank findByBranchName(String branchName);

    /**
     * Save the specified bank.
     *
     * @param bank reference to the {@link Bank} to save
     *
     * @return reference to the saved {@link Bank}
     */
    Bank save(Bank bank);

    /**
     * Delete the specified bank.
     *
     * @param bank  reference to the {@link Bank} to delete
     */
    void delete(Bank bank);

    /**
     * Update the specified bank.
     *
     * @param bank  reference to the {@link Bank} to update
     */
    void update(Bank bank);
}
