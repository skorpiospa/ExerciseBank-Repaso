package org.iesfm;

import org.iesfm.exceptions.InsufficientFoundsException;

import java.util.Objects;

public class Account {
    private String iban;
    private String nif;
    private int amount;

    public Account(String iban, String nif, int amount) {
        this.iban = iban;
        this.nif = nif;
        this.amount = amount;
    }

    public int transferMoney (int amountofTransfer) {
        amount += amountofTransfer;
        return  amount;
    }

    public  int outMoneyOfAccount(int money) throws InsufficientFoundsException {
        if (amount<money){
            throw new InsufficientFoundsException();
        }
        return amount - money;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return amount == account.amount && Objects.equals(iban, account.iban) && Objects.equals(nif, account.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, nif, amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", nif='" + nif + '\'' +
                ", amount=" + amount +
                '}';
    }
}
