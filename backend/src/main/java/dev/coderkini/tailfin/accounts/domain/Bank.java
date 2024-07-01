package dev.coderkini.tailfin.accounts.domain;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>Bank represents a branch of a banking financial institution where accounts are held.</p>
 * <p>Every bank branch in India are assigned a unique code called the IFSC or Indian Financial System Code.</p>
 */
public class Bank {
    private final BankId id;
    private String name;
    private final String branchName;
    private final IfsCode ifsc;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /**
     * Create a new Bank instance with the specified ID, name, branch name, and IFSC.
     *
     * @param id            The unique identifier for the bank.
     * @param name          The name of the bank.
     * @param branchName    The name of the branch.
     * @param ifsc          The IFSC code of the bank.
     */
    public Bank(BankId id, String name, String branchName, IfsCode ifsc) {
        this.id = id;
        this.name = name;
        this.branchName = branchName;
        this.ifsc = ifsc;
    }

    /**
     * Create a new Bank instance with the specified name, branch name, and IFSC.
     * @param name
     * @param branchName
     * @param ifsc
     */
    public Bank(String name, String branchName, IfsCode ifsc) {
        this(BankId.generate(), name, branchName, ifsc);
    }

    /**
     * Return the unique identifier for the bank.
     *
     * @return  The unique identifier for the bank.
     */
    public BankId getId() {
        return id;
    }

    /**
     * Return the name of the bank.
     * @return  The name of the bank.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the bank.
     *
     * @param name The name of the bank.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the name of the branch.
     *
     * @return The name of the branch.
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * Return the IFSC of the bank branch.
     *
     * @return  the IFSC of the bank branch.
     */
    public IfsCode getIfsc() {
        return ifsc;
    }

    /**
     * Return the date and time the bank was created.
     *
     * @return  The date and time the bank was created.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Return the date and time the bank was last updated.
     *
     * @return The date and time the bank was last updated.
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(id, bank.id) && Objects.equals(name, bank.name) && Objects.equals(ifsc, bank.ifsc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ifsc);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", branchName='" + branchName + '\'' +
                ", ifsc=" + ifsc +
                '}';
    }
}
