package org.iesfm;

import org.iesfm.exceptions.AccountNotFoundExceptions;
import org.iesfm.exceptions.CustomerNotFoundException;
import org.iesfm.exceptions.InsufficientFoundsException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BankTest {

    Bank createBank=new Bank("Caixa", clients(),accounts());

    public List<Client> clients () {
        List<Client> clientsList= new LinkedList<>();
        clientsList.add(new Client("Javier", "Moragues", "49067612",28901));
        clientsList.add(new Client("Rafael", "Moragues Fernandez","49006790", 28941));
        clientsList.add(new Client("Miriam", "Garcia", "46500000", 28901));

        return clientsList;
    }

    public Map<String, Account> accounts () {
        Map<String, Account> accountMap= new HashMap<>();
        accountMap.put("123456789", new Account("123456789","49067612", 1520));
        accountMap.put("0011223344", new Account("0011223344", "46500000", 2650));
        accountMap.put("987654321", new Account("987654321", "49006790", 100));

        return accountMap;
    }

    @Test
    public void getClient () throws CustomerNotFoundException {
        Bank bank=createBank;
        String nif="49067612";

        Client client=bank.findClient(nif);
        Assert.assertEquals("Javier", client.getName());
        Assert.assertEquals(28901,client.getZipCode());
    }

    @Test (expected = CustomerNotFoundException.class)
    public void getClientNotFound () throws CustomerNotFoundException {
        Bank bank=createBank;
        String nif="4906666";
        bank.findClient(nif);
    }

    @Test
    public void getAccountTest () throws AccountNotFoundExceptions {
        Bank bank=createBank;
        String iban="0011223344";

        Account account=bank.getAccount(iban);
        Assert.assertEquals(2650, account.getAmount());
        Assert.assertEquals("46500000", account.getNif());
    }

    @Test (expected = AccountNotFoundExceptions.class)
    public void getNotFoundAccountTest () throws AccountNotFoundExceptions {
        Bank bank=createBank;
        String iban="0011223555";
        bank.getAccount(iban);
    }

    @Test
    public void transferAmountTest () throws AccountNotFoundExceptions {
        Bank bank=createBank;
        String iban="123456789";
        String iban2="987654321";
        int amount=1000;
        bank.transferAmount(iban,amount);
        bank.transferAmount(iban2,amount);
        Assert.assertEquals(2520, bank.getAccount(iban).getAmount());
        Assert.assertEquals(1100,bank.getAccount(iban2).getAmount());
    }

    @Test
    public void outMoneyofAccountTest () throws  AccountNotFoundExceptions, InsufficientFoundsException {
        Bank bank = createBank;
        String iban = "123456789";
        int amount = 500;
        bank.outMoneyofAccount(iban,amount);
        Assert.assertEquals(1020, bank.getAccount(iban).getAmount());
    }

    @Test (expected = InsufficientFoundsException.class)
    public void InsuficientMoneyOnTransferTest () throws  AccountNotFoundExceptions, InsufficientFoundsException {
        Bank bank = createBank;
        String iban = "987654321";
        int amount = 500;
        bank.outMoneyofAccount(iban,amount);
    }

    @Test
    public void transfersInAccountsTest () throws AccountNotFoundExceptions, InsufficientFoundsException{
        Bank bank=createBank;
        String ibanOrigin="123456789";
        int amount=520;
        String ibanDestiny="987654321";
        bank.transfersInAccounts(ibanOrigin,amount,ibanDestiny);

        Assert.assertEquals(1000, bank.getAccount(ibanOrigin).getAmount());
        Assert.assertEquals(620,bank.getAccount(ibanDestiny).getAmount());
    }

}
