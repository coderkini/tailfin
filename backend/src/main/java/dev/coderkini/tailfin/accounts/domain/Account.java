package dev.coderkini.tailfin.accounts.domain;

import java.time.LocalDateTime;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

/**
 * <p>Account represents a container of monetary transactions. Accounts can be of different types. The supported types
 * are defined in the {@link AccountType} enumeration.</p>
 *
 * <p>It may optionally be associated with a bank which is when it also has an account number.</p>
 *
 * <p>An account may start with an initial balance, but this is optional which is when the balance is zero.</p>
 *
 * @see AccountId
 * @see AccountType
 * @see Bank
 * @see BankId
 * @see MonetaryAmount
 * @see LocalDateTime
 */
public class Account {

    private final AccountId id;
    private final AccountType type;
    private String number;
    private BankId bankId;
    private String displayName;
    private MonetaryAmount balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /**
     * Create a new Account instance with a unique identifier and type and zero initial balance.
     * The unique identifier is generated automatically.
     *
     * @param type  reference to the {@link AccountType} that represents the type of the account.
     */
    public Account(AccountType type) {
        this(AccountId.generate(), type);
    }

    /**
     * Create a new Account instance with the specified ID and type and zero initial balance.
     *
     * @param id        reference to {@link AccountId} that represents unique identifier for the account.
     * @param type      reference to the {@link AccountType} that represents the type of the account.
     */
    public Account(AccountId id, AccountType type) {
        this(id, type, Money.zero(Monetary.getCurrency("INR")));
    }

    /**
     * Create a new Account instance with the specified ID, type, and initial balance.
     *
     * @param id                reference to {@link AccountId} that represents unique identifier for the account.
     * @param type              reference to the {@link AccountType} that represents the type of the account.
     * @param initialBalance    reference to an instance of {@link MonetaryAmount} that represents the initial balance
     *                          of the account.
     */
    public Account(AccountId id, AccountType type, MonetaryAmount initialBalance) {
        this.id = id;
        this.type = type;
        this.balance = Money.from(initialBalance);
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Create a new Account instance with the specified ID, type, bank ID, and display name and zero initial balance.
     *
     * @param id            reference to {@link AccountId} that represents unique identifier for the account.
     * @param type          reference to the {@link AccountType} that represents the type of the account.
     * @param bankId        reference to the {@link BankId} that represents the unique identifier of the associated bank
     * @param number        The account number.
     * @param displayName   The display name for the account.
     */
    public Account(AccountId id, AccountType type, BankId bankId, String number, String displayName) {
        this(id, type, Money.zero(Monetary.getCurrency("INR")));
        this.bankId = bankId;
        this.number = number;
        this.displayName = displayName;
    }

    /**
     * Create a new Account instance with the specified ID, type, number, bank ID, display name, and specified initial
     * balance.
     *
     * @param id                reference to {@link AccountId} that represents unique identifier for the account.
     * @param type              reference to the {@link AccountType} that represents the type of the account.
     * @param bankId            reference to the {@link BankId} that represents the unique identifier of the associated bank
     * @param number            The account number.
     * @param displayName       The display name for the account.
     * @param balance           reference to an instance of {@link MonetaryAmount} that represents the initial balance
     *                          of the account.
     */
    public Account(AccountId id, AccountType type, BankId bankId, String number, String displayName, MonetaryAmount balance) {
        this(id, type, balance);
        this.number = number;
        this.bankId = bankId;
        this.displayName = displayName;
    }

    /**
     * Return the unique identifier for the account.
     *
     * @return reference to {@link AccountId} that represents unique identifier for the account.
     */
    public AccountId getId() {
        return id;
    }

    /**
     * Return the type of the account.
     *
     * @return reference to the {@link AccountType} that represents the type of the account.
     */
    public AccountType getType() {
        return type;
    }

    /**
     * Return the associated bank's unique identifier
     *
     * @return reference to the {@link BankId} that represents the unique identifier of the associated bank
     */
    public BankId getBankId() {
        return bankId;
    }

    /**
     * Return the account number.
     *
     * @return  The account number.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Return the display name for the account.
     *
     * @return The display name for the account.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Set the display name for the account.
     *
     * @param displayName   The display name for the account.
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Return the balance of the account.
     *
     * @return reference to an instance of {@link MonetaryAmount} that represents the balance of the account.
     */
    public MonetaryAmount getBalance() {
        return balance;
    }

    /**
     * Return the date and time when the account was created.
     *
     * @return  reference to the {@link LocalDateTime} that represents the date and time when the account was created.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Return the date and time when the account was last updated.
     *
     * @return  reference to the {@link LocalDateTime} that represents the date and time when the account was updated.
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
