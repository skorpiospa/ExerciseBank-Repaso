package org.iesfm;

import org.iesfm.exceptions.AccountNotFoundExceptions;
import org.iesfm.exceptions.CustomerNotFoundException;
import org.iesfm.exceptions.InsufficientFoundsException;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Bank implements iBank {

    private String name;
    private List<Client> clients;
    private Map<String, Account> accounts;

    public Bank(String name, List<Client> clients, Map<String, Account> accounts) {
        this.name = name;
        this.clients = clients;
        this.accounts = accounts;
    }

    public Client findClient (String nif) throws CustomerNotFoundException {
        for (Client client:clients){
            if (client.getNifClient().equals(nif)){
                return client;
            }
        }
        throw new CustomerNotFoundException(nif);
    }

    public Account getAccount (String iban) throws AccountNotFoundExceptions {
        if (accounts.containsKey(iban)){
            return accounts.get(iban);
        }
        throw new AccountNotFoundExceptions(iban);
    }
    @Override
    public void transferAmount(String iban, int amountTransfer) throws AccountNotFoundExceptions {
        if (!accounts.containsKey(iban)){
            throw new AccountNotFoundExceptions(iban);
        }
        getAccount(iban).transferMoney(amountTransfer);
    }

    @Override
    public List<Account> getAccountofClient(String nif) throws CustomerNotFoundException {
        List<Account> accountsClient = new LinkedList<>();
        for (Account account : accounts.values()) {
            if (account.getNif().equals(nif)) {
                accountsClient.add(account);
            }
        }
        if (accountsClient.isEmpty()) {
            throw new CustomerNotFoundException(nif);
        }
        return accountsClient;
    }

    @Override
    public void outMoneyofAccount(String iban, int amount) throws AccountNotFoundExceptions, InsufficientFoundsException {
        Account account=getAccount(iban);
        account.outMoneyOfAccount(amount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.equals(clients, bank.clients) && Objects.equals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, clients, accounts);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", clients=" + clients +
                ", accounts=" + accounts +
                '}';
    }

}
