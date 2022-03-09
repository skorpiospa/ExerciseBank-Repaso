package org.iesfm;

import org.iesfm.exceptions.AccountNotFoundExceptions;
import org.iesfm.exceptions.CustomerNotFoundException;
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
        

    }


}
